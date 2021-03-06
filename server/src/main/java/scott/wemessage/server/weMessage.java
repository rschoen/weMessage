/*
 *  weMessage - iMessage for Android
 *  Copyright (C) 2018 Roman Scott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package scott.wemessage.server;

import scott.wemessage.commons.Constants;

public final class weMessage implements Constants {

    private weMessage(){ }

    public static final int WEMESSAGE_CONFIG_VERSION = 3;
    public static final int WEMESSAGE_DATABASE_VERSION = 2;
    public static final int WEMESSAGE_APPLESCRIPT_VERSION = 11;
    public static final int MIN_OS_VERSION = 10;

    public static final boolean DEFAULT_CREATE_LOG_FILES = true;
    public static final boolean DEFAULT_CHECK_FOR_UPDATES = true;
    public static final boolean DEFAULT_SEND_CRASH_REPORTS = true;
    public static final boolean DEFAULT_SEND_NOTIFICATIONS = true;
    public static final boolean DEFAULT_TRANSCODE_VIDEO = true;
    public static final boolean DEFAULT_SYNC_CONTACT_PHOTOS = true;

    public static final String CONFIG_FILE_NAME = "config.json";
    public static final String LOG_FILE_NAME = "latest.log";
    public static final String SERVER_DATABASE_FILE_NAME = "weserver.db";
    public static final String DEFAULT_FFMPEG_LOCATION = "bin/ffmpeg/ffmpeg";
    public static final String DEFAULT_EMAIL = "email@icloud.com";
    public static final String DEFAULT_SECRET = "secret";

    public static final String GET_VERSION_FUNCTION_URL = "https://us-central1-rymessage-75dfa.cloudfunctions.net/getVersion";
    public static final String NOTIFICATION_FUNCTION_URL = "https://us-central1-rymessage-75dfa.cloudfunctions.net/sendNotification";
    public static final String SENTRY_DSN = "https://b57de61f5e5d4898999fb49408675ae5:32185c3f6298464fab810ffa40a54b74@sentry.io/250857";
}