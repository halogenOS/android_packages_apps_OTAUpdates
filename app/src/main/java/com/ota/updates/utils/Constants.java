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

import android.os.Environment;

import com.ota.updates.BuildConfig;

public interface Constants {
    // Developer
    boolean DEBUGGING                           = BuildConfig.DEBUG;

    // Props
    String OTA_ROMNAME                      = "persist.ota.romname";
    String OTA_VERSION                      = "persist.ota.version";
    String OTA_MANIFEST                     = "persist.ota.manifest";
    String OTA_DOWNLOAD_LOC                 = "persist.ota.download_loc";

    // Storage
    String SD_CARD                          = Environment.getExternalStorageDirectory().getAbsolutePath();
    String OTA_DOWNLOAD_DIR                 = Utils.doesPropExist(OTA_DOWNLOAD_LOC) ? Utils.getProp(OTA_DOWNLOAD_LOC) : "OTAUpdates";
    String INSTALL_AFTER_FLASH_DIR          = "InstallAfterFlash";

    // Networks
    String WIFI_ONLY                        = "2";

    // Settings
    String CURRENT_THEME                    = "current_theme";
    String LAST_CHECKED                     = "updater_last_update_check";
    String IS_DOWNLOAD_FINISHED             = "is_download_finished";
    String DELETE_AFTER_INSTALL             = "delete_after_install";
    String INSTALL_PREFS                    = "install_prefs";
    String WIPE_DATA                        = "wipe_data";
    String WIPE_CACHE                       = "wipe_cache";
    String WIPE_DALVIK                      = "wipe_dalvik";
    String MD5_PASSED                       = "md5_passed";
    String MD5_RUN                          = "md5_run";
    String DOWNLOAD_RUNNING                 = "download_running";
    String NETWORK_TYPE                     = "network_type";
    String DOWNLOAD_ID                      = "download_id";
    String UPDATER_BACK_SERVICE             = "background_service";
    String UPDATER_BACK_FREQ                = "background_frequency";
    String UPDATER_ENABLE_ORS               = "updater_twrp_ors";
    String NOTIFICATIONS_SOUND              = "notifications_sound";
    String NOTIFICATIONS_VIBRATE            = "notifications_vibrate";
    String IGNORE_RELEASE_VERSION           = "ignored_release";
    String OLD_CHANGELOG                    = "old_changelog";
    String FIRST_RUN                        = "first_run";
    String ABOUT_ACTIVITY_PREF              = "about_activity_pref";
    String STORAGE_LOCATION                 = "updater_storage_location";

    // Broadcast intents
    String MANIFEST_LOADED                  = "com.ota.update.MANIFEST_LOADED";
    String MANIFEST_CHECK_BACKGROUND        = "com.ota.update.MANIFEST_CHECK_BACKGROUND";
    String START_UPDATE_CHECK               = "com.ota.update.START_UPDATE_CHECK";
    String IGNORE_RELEASE                   = "com.ota.update.IGNORE_RELEASE";

    //Notification
    int NOTIFICATION_ID                         = 101;
}
