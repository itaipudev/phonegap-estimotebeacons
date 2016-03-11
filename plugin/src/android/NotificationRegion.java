package com.evothings;

import android.os.Parcel;
import android.os.Parcelable;

import com.estimote.sdk.Region;

import java.util.UUID;

/**
 * Created by João Gonçalves (jppg) on 03/03/16.
 */
public class NotificationRegion extends Region implements Parcelable {

    private String enterTitle;
    private String exitTitle;
    private String enterMessage;
    private String exitMessage;
    private String deeplink;

    public String getDeeplink() {
        return deeplink;
    }

    public String getEnterMessage() {
        return enterMessage;
    }

    public String getEnterTitle() {
        return enterTitle;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public String getExitTitle() {
        return exitTitle;
    }

    public NotificationRegion(String identifier, UUID proximityUUID, Integer major, Integer minor, String enterMessage, String enterTitle, String exitMessage, String exitTitle, String deeplink) {
        super(identifier, proximityUUID, major, minor);
        this.enterMessage = enterMessage;
        this.enterTitle = enterTitle;
        this.exitMessage = exitMessage;
        this.exitTitle = exitTitle;
        this.deeplink = deeplink;
    }

    public NotificationRegion(Region region, String enterMessage, String enterTitle, String exitMessage, String exitTitle, String deeplink) {
        this(region.getIdentifier(), region.getProximityUUID(), region.getMajor(), region.getMinor(), enterMessage, enterTitle, exitMessage, exitTitle, deeplink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        NotificationRegion that = (NotificationRegion) o;

        if (enterTitle != null ? !enterTitle.equals(that.enterTitle) : that.enterTitle != null)
            return false;
        if (exitTitle != null ? !exitTitle.equals(that.exitTitle) : that.exitTitle != null)
            return false;
        if (enterMessage != null ? !enterMessage.equals(that.enterMessage) : that.enterMessage != null)
            return false;
        if (exitMessage != null ? !exitMessage.equals(that.exitMessage) : that.exitMessage != null)
            return false;
        return !(deeplink != null ? !deeplink.equals(that.deeplink) : that.deeplink != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (enterTitle != null ? enterTitle.hashCode() : 0);
        result = 31 * result + (exitTitle != null ? exitTitle.hashCode() : 0);
        result = 31 * result + (enterMessage != null ? enterMessage.hashCode() : 0);
        result = 31 * result + (exitMessage != null ? exitMessage.hashCode() : 0);
        result = 31 * result + (deeplink != null ? deeplink.hashCode() : 0);
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(enterTitle);
        dest.writeString(exitTitle);
        dest.writeString(enterMessage);
        dest.writeString(exitMessage);
        dest.writeString(deeplink);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotificationRegion> CREATOR = new Creator<NotificationRegion>() {
        @Override
        public NotificationRegion createFromParcel(Parcel in) {
            final Region tmpRegion = Region.CREATOR.createFromParcel(in);
            final String enterTitle = in.readString();
            final String exitTitle = in.readString();
            final String enterMessage = in.readString();
            final String exitMessage = in.readString();
            final String deeplink = in.readString();
            return new NotificationRegion(tmpRegion, enterMessage, enterTitle, exitMessage, exitTitle, deeplink);
        }

        @Override
        public NotificationRegion[] newArray(int size) {
            return new NotificationRegion[size];
        }
    };
}