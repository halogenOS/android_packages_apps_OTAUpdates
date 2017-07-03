#	Copyright (C) 2015 Matt Booth (Kryten2k35).
#       Copyright (C) 2017 The halogenOS Project.
#
# 	Licensed under the Attribution-NonCommercial-ShareAlike 4.0 International
# 	(the "License") you may not use this file except in compliance with the License.
# 	You may obtain a copy of the License at
#
# 		http://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
#
# 	Unless required by applicable law or agreed to in writing, software
# 	distributed under the License is distributed on an "AS IS" BASIS,
#	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#	See the License for the specific language governing permissions and
#	limitations under the License.

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

ifndef TARGET_ARCH_ABI
TARGET_ARCH_ABI := armeabi-v7a
endif

# Cardview Dir
cardview_dir := $(LOCAL_PATH)/../../../frameworks/support/v7/cardview

LOCAL_MANIFEST_FILE := app/src/main/AndroidManifest.xml
LOCAL_SRC_FILES := $(call all-java-files-under, app/src/main)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/app/src/main/res
LOCAL_RESOURCE_DIR += $(cardview_dir)/res

LOCAL_AAPT_FLAGS := \
	--auto-add-overlay \
	--extra-packages android.support.v7.cardview \
        --extra-packages android.support.v4

LOCAL_PACKAGE_NAME := OTAUpdates

LOCAL_MODULE_TAGS := optional

LOCAL_STATIC_JAVA_LIBRARIES := \
	android-support-v4 \
	android-support-v7-cardview

LOCAL_JNI_SHARED_LIBRARIES := libbypass

LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
LOCAL_PROGUARD_ENABLED := disabled
include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

include $(call all-makefiles-under,$(LOCAL_PATH))
