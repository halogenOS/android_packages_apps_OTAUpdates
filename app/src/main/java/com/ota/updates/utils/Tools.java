/*
 * Copyright (C) 2015 Matt Booth (Kryten2k35).
 * Copyright (C) 2017 The halogenOS Project.
 *
 * Licensed under the Attribution-NonCommercial-ShareAlike 4.0 International
 * (the "License") you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ota.updates.utils;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

public class Tools implements Constants {

    public final String TAG = this.getClass().getSimpleName();

    public static boolean recovery(Context context) {
        return rebootPhone(context, "recovery");
    }

    private static boolean rebootPhone(Context context, String type) {
        boolean success = true;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            powerManager.reboot("recovery");
        } catch (Exception e) {
            success = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
            Log.e("Tools", "reboot '"+type+"' error: "+e.getMessage());
        }
        return success;
    }

}
