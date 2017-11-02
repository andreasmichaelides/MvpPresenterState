package app.mvp.com.presenterinstance;

/**
 * Created by westplay on 13/08/17.
 */

interface DataProvider {

    State getData();

    void restoreData(State state);

}
