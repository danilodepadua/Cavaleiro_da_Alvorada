package com.mygdx.game.Profile;

public interface ProfileObserver {
    enum ProfileEvent {
        PROFILE_LOADED,
        SAVING_PROFILE,
        CLEAR_CURRENT_PROFILE
    }

    void onNotify(final ProfileManager profileManager, ProfileEvent event);
}
