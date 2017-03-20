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
package com.ota.updates.download;


import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.ota.updates.OtaUpdates;
import com.ota.updates.utils.Constants;
import com.ota.updates.utils.Preferences;

public class DownloadAddon implements Constants {

    public final String TAG = getClass().getName();

    public DownloadAddon() {

    }

    public void startDownload(Context context, String url, String fileName, int id, int index) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

        if(Preferences.getNetworkType(context).equals(WIFI_ONLY)) {
            // All network types are enabled by default
            // So if we choose Wi-Fi only, then enable the restriction
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        }

        request.setTitle(fileName);

        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        fileName = fileName + ".zip";
        request.setDestinationInExternalPublicDir(OTA_DOWNLOAD_DIR, fileName);

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        long mDownloadID = downloadManager.enqueue(request);
        OtaUpdates.putAddonDownload(index, mDownloadID);
        new DownloadAddonProgress(downloadManager, index).execute(mDownloadID);
        if (DEBUGGING) {
            Log.d(TAG, "Starting download with manager ID " + mDownloadID + " and item id of " + id);
        }
    }

    public void cancelDownload(Context context, int index) {
        long mDownloadID = OtaUpdates.getAddonDownload(index);
        if (DEBUGGING) {
            Log.d(TAG, "Stopping download with manager ID " + mDownloadID + " and item index of " + index);
        }
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.remove(mDownloadID);
    }
}
