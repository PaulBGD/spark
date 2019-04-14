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

package me.lucko.spark.monitor.data;

import com.google.gson.JsonElement;

import java.util.function.Supplier;

public interface DataProvider {

    static DataProvider syncProvider(Supplier<JsonElement> supplier) {
        return new DataProvider() {
            @Override
            public JsonElement gather() {
                return supplier.get();
            }

            @Override
            public boolean requiresSync() {
                return true;
            }
        };
    }

    JsonElement gather();

    default boolean requiresSync() {
        return false;
    }

}
