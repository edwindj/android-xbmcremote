package org.xbmc.android.remote.business;

import java.util.ArrayList;

import org.xbmc.api.business.DataResponse;
import org.xbmc.api.business.INotifiableManager;
import org.xbmc.api.business.ISortableManager;
import org.xbmc.api.business.ITvShowManager;
import org.xbmc.api.object.Actor;
import org.xbmc.api.object.Genre;
import org.xbmc.api.object.TvShow;

import android.content.Context;
import android.content.SharedPreferences;

public class TvShowManager extends AbstractManager implements ITvShowManager,
		ISortableManager, INotifiableManager {


	public void setPreferences(SharedPreferences pref) {
		// TODO Auto-generated method stub

	}

	public void setSortKey(int sortKey) {
		// TODO Auto-generated method stub

	}

	public void getTvShowActors(final DataResponse<ArrayList<Actor>> response, final Context context) {
		mHandler.post(new Command<ArrayList<Actor>>(response, this) {
			@Override
			public void doRun() throws Exception {
				response.value = shows(context).getTvShowActors(TvShowManager.this);
			}
		});
	}

	public void getTvShowGenres(final DataResponse<ArrayList<Genre>> response, final Context context) {
		mHandler.post(new Command<ArrayList<Genre>>(response, this) {
			@Override
			public void doRun() throws Exception {
				response.value = shows(context).getTvShowGenres(TvShowManager.this);
			}
		});
	}

	public void getTvShows(final DataResponse<ArrayList<TvShow>> response,
			final int sortBy,final String sortOrder, final Context context) {
		mHandler.post(new Command<ArrayList<TvShow>>(response, this) {
			@Override
			public void doRun() throws Exception {
				response.value = shows(context).getTvShows(TvShowManager.this, sortBy, sortOrder);
			}
		});
	}

	public void getTvShows(final DataResponse<ArrayList<TvShow>> response, final Genre genre, final Context context) {
		mHandler.post(new Command<ArrayList<TvShow>>(response, this) {
			@Override
			public void doRun() throws Exception {
				response.value = shows(context).getTvShows(TvShowManager.this, genre);
			}
		});
	}

}