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

import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AddonXmlParser extends DefaultHandler implements Constants {

    private final static String TAG = "AddonXmlParser";

    public static ArrayList<Addon> parse(File xmlFile) {
        ArrayList<Addon> addons = null;
        try {
            SAXParserFactory xmlReader = SAXParserFactory.newInstance();
            SAXParser saxParser = xmlReader.newSAXParser();
            AddonsSaxHandler saxHandler = new AddonsSaxHandler();
            saxParser.parse(xmlFile, saxHandler);
            addons = saxHandler.getAddons();
        } catch (Exception ex) {
            Log.d(TAG, "SAXXMLParser: parse() failed");
        }
        return addons;
    }
}