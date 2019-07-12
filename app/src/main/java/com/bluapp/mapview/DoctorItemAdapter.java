package com.bluapp.mapview;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorItemAdapter extends AbstractItem<DoctorItemAdapter, DoctorItemAdapter.ViewHolder> {


    private final int VIEW_TYPE = 2222;

    private DoctorModel doctorModel;


    public DoctorItemAdapter(DoctorModel doctorModel) {
        this.doctorModel = doctorModel;
    }

    public DoctorModel getDoctorModel() {
        return doctorModel;
    }


    @NonNull
    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.doctor_item_layout;
    }


    public static class ViewHolder extends FastAdapter.ViewHolder<DoctorItemAdapter>{
        private CircleImageView doctorImage;
        private AppCompatTextView doctorName;
        private AppCompatTextView doctorExpertise;
        private AppCompatTextView doctorAddress;
        private AppCompatTextView doctorExp;
        private AppCompatTextView doctorFees;
        private AppCompatTextView doctorRank;

        public ViewHolder(View itemView) {
            super(itemView);
            doctorImage = (CircleImageView)itemView.findViewById(R.id.profile_image);
            doctorName = (AppCompatTextView)itemView.findViewById(R.id.doctor_name);
            doctorExpertise = (AppCompatTextView)itemView.findViewById(R.id.expertise);
            doctorAddress = (AppCompatTextView)itemView.findViewById(R.id.address);
            doctorExp = (AppCompatTextView)itemView.findViewById(R.id.exp);
            doctorFees = (AppCompatTextView)itemView.findViewById(R.id.fees);
            doctorRank = (AppCompatTextView)itemView.findViewById(R.id.rank);



        }

        @Override
        public void bindView(@NonNull DoctorItemAdapter item, @NonNull List<Object> payloads) {
            doctorImage.setImageResource(item.getDoctorModel().getImagePath());
            doctorName.setText(item.getDoctorModel().getName());
            doctorExpertise.setText(item.getDoctorModel().getExpertise());
            doctorAddress.setText(item.getDoctorModel().getAddress());
            doctorExp.setText(item.getDoctorModel().getExp());
            doctorFees.setText(item.getDoctorModel().getFees());
            doctorRank.setText(item.getDoctorModel().getRank());
        }

        @Override
        public void unbindView(@NonNull DoctorItemAdapter item) {
            doctorName.setText(null);
            doctorExpertise.setText(null);
            doctorAddress.setText(null);
            doctorExp.setText(null);
            doctorFees.setText(null);
            doctorRank.setText(null);
        }
    }
}
