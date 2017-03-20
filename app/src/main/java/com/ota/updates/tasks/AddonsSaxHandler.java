/*
 * Copyright (C) 2015 Matt Booth (Kryten2k35).
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

package com.ota.updates.tasks;

import android.util.Log;

import com.ota.updates.Addon;
import com.ota.updates.utils.Constants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

class AddonsSaxHandler extends DefaultHandler implements Constants {

    private final String TAG = this.getClass().getSimpleName();

    private ArrayList<Addon> addons;
    private String tempVal;
    private Addon tempAddon;

    AddonsSaxHandler() {
        addons = new ArrayList<>();
    }

    ArrayList<Addon> getAddons() {
        return addons;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("addon")) {
            // create a new instance of employee
            tempAddon = new Addon();
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("addon")) {
            // add it to the list
            addons.add(tempAddon);
        } else if (qName.equalsIgnoreCase("name")) {
            tempAddon.setTitle(tempVal);
            if (DEBUGGING)
                Log.d(TAG, "Title = " + tempVal);
        } else if (qName.equalsIgnoreCase("description")) {
            tempAddon.setDesc(tempVal);
            if (DEBUGGING)
                Log.d(TAG, "Desc = " + tempVal);
        } else if (qName.equalsIgnoreCase("published-at")) {
            String[] splitInput = tempVal.split("T");
            tempAddon.setPublishedAt(splitInput[0]);
            if (DEBUGGING)
                Log.d(TAG, "Updated On = " + tempVal);
        } else if (qName.equalsIgnoreCase("download-link")) {
            tempAddon.setDownloadLink(tempVal);
            if (DEBUGGING)
                Log.d(TAG, "Download Link = " + tempVal);
        } else if (qName.equalsIgnoreCase("size")) {
            tempAddon.setFilesize(Integer.parseInt(tempVal));
            if (DEBUGGING)
                Log.d(TAG, "Size = " + tempVal);
        } else if (qName.equalsIgnoreCase("id")) {
            tempAddon.setId(Integer.parseInt(tempVal));
            if (DEBUGGING)
                Log.d(TAG, "Id = " + tempVal);
        }
    }

}
