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

import java.util.HashMap;

public enum PNXEntityType {
    STRIDER("minecraft:strider"),

    TADPOLE("minecraft:tadpole"),

    PIGLIN_BRUTE("minecraft:piglin_brute"),

    FROG("minecraft:frog"),

    ZOGLIN("minecraft:zoglin"),

    PIGLIN("minecraft:piglin"),

    HOGLIN("minecraft:hoglin"),

    BEE("minecraft:bee"),

    FOX("minecraft:fox"),

    SNOW_GOLEM("minecraft:snow_golem"),

    PLAYER("minecraft:player"),

    AXOLOTL("minecraft:axolotl"),

    WANDERING_TRADER("minecraft:wandering_trader"),

    COW("minecraft:cow"),

    CAMEL("minecraft:camel"),

    ALLAY("minecraft:allay"),

    WARDEN("minecraft:warden"),

    TRIPOD_CAMERA("minecraft:tripod_camera"),

    NPC("minecraft:npc"),

    BALLOON("minecraft:balloon"),

    ICE_BOMB("minecraft:ice_bomb"),

    AGENT("minecraft:agent"),

    GLOW_SQUID("minecraft:glow_squid"),

    GOAT("minecraft:goat"),

    PILLAGER("minecraft:pillager"),

    VEX("minecraft:vex"),

    EVOCATION_ILLAGER("minecraft:evocation_illager"),

    EVOCATION_FANG("minecraft:evocation_fang"),

    FIREWORKS_ROCKET("minecraft:fireworks_rocket"),

    LINGERING_POTION("minecraft:lingering_potion"),

    AREA_EFFECT_CLOUD("minecraft:area_effect_cloud"),

    LLAMA_SPIT("minecraft:llama_spit"),

    SMALL_FIREBALL("minecraft:small_fireball"),

    LIGHTNING_BOLT("minecraft:lightning_bolt"),

    BOAT("minecraft:boat"),

    CHEST_BOAT("minecraft:chest_boat"),

    WITHER_SKULL_DANGEROUS("minecraft:wither_skull_dangerous"),

    WITHER_SKULL("minecraft:wither_skull"),

    LEASH_KNOT("minecraft:leash_knot"),

    ENDER_PEARL("minecraft:ender_pearl"),

    SPLASH_POTION("minecraft:splash_potion"),

    FIREBALL("minecraft:fireball"),

    THROWN_TRIDENT("minecraft:thrown_trident"),

    PAINTING("minecraft:painting"),

    EGG("minecraft:egg"),

    SNOWBALL("minecraft:snowball"),

    ARROW("minecraft:arrow"),

    DRAGON_FIREBALL("minecraft:dragon_fireball"),

    FISHING_HOOK("minecraft:fishing_hook"),

    SHULKER_BULLET("minecraft:shulker_bullet"),

    ENDER_CRYSTAL("minecraft:ender_crystal"),

    EYE_OF_ENDER_SIGNAL("minecraft:eye_of_ender_signal"),

    XP_ORB("minecraft:xp_orb"),

    XP_BOTTLE("minecraft:xp_bottle"),

    FALLING_BLOCK("minecraft:falling_block"),

    TNT("minecraft:tnt"),

    ITEM("minecraft:item"),

    ARMOR_STAND("minecraft:armor_stand"),

    COMMAND_BLOCK_MINECART("minecraft:command_block_minecart"),

    CHEST_MINECART("minecraft:chest_minecart"),

    TNT_MINECART("minecraft:tnt_minecart"),

    HOPPER_MINECART("minecraft:hopper_minecart"),

    ZOMBIE_HORSE("minecraft:zombie_horse"),

    DOLPHIN("minecraft:dolphin"),

    PUFFERFISH("minecraft:pufferfish"),

    GUARDIAN("minecraft:guardian"),

    MULE("minecraft:mule"),

    MINECART("minecraft:minecart"),

    COD("minecraft:cod"),

    ENDER_DRAGON("minecraft:ender_dragon"),

    DONKEY("minecraft:donkey"),

    TROPICALFISH("minecraft:tropicalfish"),

    WITHER("minecraft:wither"),

    SKELETON_HORSE("minecraft:skeleton_horse"),

    PANDA("minecraft:panda"),

    SHULKER("minecraft:shulker"),

    LLAMA("minecraft:llama"),

    HORSE("minecraft:horse"),

    CHICKEN("minecraft:chicken"),

    PARROT("minecraft:parrot"),

    TRADER_LLAMA("minecraft:trader_llama"),

    SILVERFISH("minecraft:silverfish"),

    SNIFFER("minecraft:sniffer"),

    PIG("minecraft:pig"),

    SHEEP("minecraft:sheep"),

    WOLF("minecraft:wolf"),

    VILLAGER("minecraft:villager"),

    TURTLE("minecraft:turtle"),

    POLAR_BEAR("minecraft:polar_bear"),

    VILLAGER_V2("minecraft:villager_v2"),

    MOOSHROOM("minecraft:mooshroom"),

    CAT("minecraft:cat"),

    SQUID("minecraft:squid"),

    RABBIT("minecraft:rabbit"),

    BAT("minecraft:bat"),

    IRON_GOLEM("minecraft:iron_golem"),

    SALMON("minecraft:salmon"),

    ELDER_GUARDIAN("minecraft:elder_guardian"),

    OCELOT("minecraft:ocelot"),

    ZOMBIE("minecraft:zombie"),

    CREEPER("minecraft:creeper"),

    SKELETON("minecraft:skeleton"),

    SPIDER("minecraft:spider"),

    ZOMBIE_PIGMAN("minecraft:zombie_pigman"),

    SLIME("minecraft:slime"),

    ENDERMAN("minecraft:enderman"),

    CAVE_SPIDER("minecraft:cave_spider"),

    GHAST("minecraft:ghast"),

    MAGMA_CUBE("minecraft:magma_cube"),

    BLAZE("minecraft:blaze"),

    ZOMBIE_VILLAGER("minecraft:zombie_villager"),

    ZOMBIE_VILLAGER_V2("minecraft:zombie_villager_v2"),

    VINDICATOR("minecraft:vindicator"),

    WITCH("minecraft:witch"),

    STRAY("minecraft:stray"),

    HUSK("minecraft:husk"),

    DROWNED("minecraft:drowned"),

    WITHER_SKELETON("minecraft:wither_skeleton"),

    ELDER_GUARDIAN_GHOST("minecraft:elder_guardian_ghost"),

    PHANTOM("minecraft:phantom"),

    RAVAGER("minecraft:ravager"),

    ENDERMITE("minecraft:endermite");
    String id;

    PNXEntityType(String id) {
        this.id = id;
    }

    static HashMap<String,PNXEntityType> maps = new HashMap<>();

    static {
        for(var v : values()){
            maps.put(v.id,v);
        }
    }


    public static PNXEntityType fromID(String id){
        return maps.get(id);
    }
}
