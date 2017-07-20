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

package com.ota.updates.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.ota.updates.R;
import com.ota.updates.adapters.CreditsAdapter;
import com.ota.updates.tasks.Changelog;
import com.ota.updates.types.CreditsItem;

import java.util.ArrayList;


public class AboutActivity extends Activity {

    private Context mContext;

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ota_about);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        setActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));


        CardView creditsView = (CardView) findViewById(R.id.credits_cardview);
        creditsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(mContext)
                        .setAdapter(new CreditsAdapter(mContext, getListData()), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //pass
                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });
        TextView versionSummary = (TextView) findViewById(R.id.about_tv_version_summary);
        String appVer = getResources().getString(R.string.about_app_version);
        String appVerActual = getResources().getString(R.string.app_version);
        versionSummary.setText(appVer + " v" + appVerActual);
        versionSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangelog(view);
            }
        });
    }

    public void openChangelog(View v) {
        String title = getResources().getString(R.string.changelog);
        String changelog = getResources().getString(R.string.changelog_url);
        new Changelog(this, mContext, title, changelog, true).execute();
    }

    public ArrayList<CreditsItem> getListData(){
        ArrayList<CreditsItem> returnedArray = new ArrayList<>();
        returnedArray.add(new CreditsItem("Matthew Booth","Anything not mentioned below"));
                returnedArray.add(new CreditsItem("Harsh Shandilya","Nougat bringup and code cleanup"));
                returnedArray.add(new CreditsItem("Roman Nurik","Android Asset Studio Framework"));
                returnedArray.add(new CreditsItem("StackOverflow","Many many people"));

        return returnedArray;

    }
}
