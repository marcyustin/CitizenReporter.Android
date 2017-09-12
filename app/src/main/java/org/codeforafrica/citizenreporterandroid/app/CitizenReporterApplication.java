package org.codeforafrica.citizenreporterandroid.app;

import android.app.Application;
import android.util.Log;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.List;
import javax.inject.Inject;
import org.codeforafrica.citizenreporterandroid.data.DataManager;
import org.codeforafrica.citizenreporterandroid.data.models.Assignment;
import org.codeforafrica.citizenreporterandroid.di.AppComponent;
import org.codeforafrica.citizenreporterandroid.di.AppModule;
import org.codeforafrica.citizenreporterandroid.di.DaggerAppComponent;

/**
 * Created by Ahereza on 9/1/17.
 */

public class CitizenReporterApplication extends Application {
  private static final String TAG = CitizenReporterApplication.class.getSimpleName();
  private AppComponent appComponent;
  @Inject DataManager manager;

  public AppComponent getAppComponent() {
    return appComponent;
  }


  @Override
  public void onCreate() {
    super.onCreate();
    Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("11235813")
        .server("http://creporter-server.herokuapp.com/parse/")
        .enableLocalDataStore()
        .build()
    );
    ParseFacebookUtils.initialize(this);

    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
    appComponent.inject(this);
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Assignment");
    query.findInBackground(new FindCallback<ParseObject>() {
      @Override public void done(List<ParseObject> objects, ParseException e) {
        if (objects != null) {
          Log.d(TAG, "Got all assignments: " + objects.size());
        }

        ParseObject.pinAllInBackground(objects);
      }
    });
    manager.getAssignments();
  }
}
