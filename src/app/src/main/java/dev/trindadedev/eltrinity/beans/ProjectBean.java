package dev.trindadedev.eltrinity.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dev.trindadedev.eltrinity.utils.ParcelUtil;

public class ProjectBean extends BaseBean implements Parcelable {
  public static final Creator<ProjectBean> CREATOR =
      new Creator<ProjectBean>() {
        public ProjectBean createFromParcel(Parcel parcel) {
          return new ProjectBean(parcel);
        }

        public ProjectBean[] newArray(int size) {
          return new ProjectBean[size];
        }
      };

  public ProjectBasicInfoBean basicInfo;

  public ProjectBean() {
    basicInfo = new ProjectBasicInfoBean();
  }

  public ProjectBean(final Parcel parcel) {
    basicInfo = ParcelUtil.readParcelable(parcel, ProjectBasicInfoBean.class);
  }

  public void copy(final ProjectBean other) {
    basicInfo = other.basicInfo;
  }

  @Override
  public Creator getCreator() {
    return CREATOR;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void print() {
    basicInfo.print();
  }

  @Override
  public void writeToParcel(final Parcel parcel, final int flags) {
    parcel.writeParcelable(basicInfo, flags);
  }
}
