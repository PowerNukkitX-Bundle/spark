/*
 * This file is part of spark.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.lucko.spark.nukkit;

import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityID;
import cn.nukkit.level.Level;
import cn.nukkit.level.format.Chunk;
import cn.nukkit.level.format.IChunk;
import me.lucko.spark.common.platform.world.AbstractChunkInfo;
import me.lucko.spark.common.platform.world.ChunkInfo;
import me.lucko.spark.common.platform.world.CountMap;
import me.lucko.spark.common.platform.world.WorldInfoProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PNXWorldInfoProvider implements WorldInfoProvider {
    private final Server server;

    public PNXWorldInfoProvider(Server server) {
        this.server = server;
    }

    @Override
    public CountsResult pollCounts() {
        int players = this.server.getOnlinePlayers().size();
        int entities = 0;
        int tileEntities = 0;
        int chunks = 0;

        for (Level world : this.server.getLevels().values()) {
            entities += world.getEntities().length;
            tileEntities += world.getBlockEntities().size();
            chunks += world.getChunks().size();
        }

        return new CountsResult(players, entities, tileEntities, chunks);
    }

    @Override
    public ChunksResult<?> pollChunks() {
        ChunksResult<PNXChunkInfo> data = new ChunksResult<>();
        for (Level world : this.server.getLevels().values()) {
            Collection<IChunk> chunks = world.getChunks().values();

            List<PNXChunkInfo> list = new ArrayList<>(chunks.size());
            for (IChunk chunk : chunks) {
                if (chunk != null) {
                    list.add(new PNXChunkInfo(chunk));
                }
            }

            data.put(world.getName(), list);
        }
        return data;
    }

    static final class PNXChunkInfo extends AbstractChunkInfo<PNXEntityType> {
        private final CountMap<PNXEntityType> entityCounts;

        PNXChunkInfo(IChunk chunk) {
            super(chunk.getX(), chunk.getZ());

            this.entityCounts = new CountMap.EnumKeyed<>(PNXEntityType.class);
            for (Entity entity : chunk.getEntities().values()) {
                if (entity != null) {
                    this.entityCounts.increment(PNXEntityType.fromID(entity.getIdentifier()));
                }
            }
        }

        @Override
        public CountMap<PNXEntityType> getEntityCounts() {
            return this.entityCounts;
        }

        @SuppressWarnings("deprecation")
        @Override
        public String entityTypeName(PNXEntityType type) {
            return type.name().toLowerCase();
        }

    }
}
