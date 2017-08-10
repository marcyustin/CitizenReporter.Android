package org.codeforafrica.citizenreporterandroid.utils;

/**
 * Created by Ahereza on 7/31/17.
 */


public class Constants {
    public static final String DB_NAME = "citizenReporterDB";
    public static final int DB_VERSION = 1;

    // stories table
    public static final String STORIES_TABLE_NAME = "storiesTBL";

    // stories columns

    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_ASSIGNMENT_ID = "assignment";
    public static final String KEY_WHY = "why";
    public static final String KEY_WHO = "who";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_AUTHOR_ID = "author_id";
    public static final String KEY_WHEN = "q_when";
    public static final String KEY_MEDIA = "media";
    public static final String KEY_UPLOADED = "uploaded";
    public static final String KEY_UPDATED = "updated";
    public static final String KEY_WHERE = "location";

    // storyboard

    public static final int REQUEST_RECORD_AUDIO = 321;
    public static final String RECORDING_PREFIX = "/creporter_";
    public static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 31;
    public static final String AUDIO_MIMETYPE = "audio/x-wav";

    // intents

    public static final String ACTION_EDIT_VIEW_STORY = "EDIT_VIEW_STORY";
}
