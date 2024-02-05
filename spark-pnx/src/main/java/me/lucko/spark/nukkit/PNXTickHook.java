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

import cn.nukkit.command.CommandExecutor;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.TaskHandler;
import me.lucko.spark.common.SparkPlatform;
import me.lucko.spark.common.sampler.ThreadDumper;
import me.lucko.spark.common.tick.AbstractTickHook;
import me.lucko.spark.common.tick.TickHook;

public class PNXTickHook extends AbstractTickHook implements TickHook, Runnable {
    private final Plugin plugin;
    private TaskHandler task;

    public PNXTickHook(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        onTick();
    }

    @Override
    public void start() {
        this.task = this.plugin.getServer().getScheduler().scheduleDelayedRepeatingTask(this.plugin, this, 1,1);
    }

    @Override
    public void close() {
        this.task.cancel();
    }

}
