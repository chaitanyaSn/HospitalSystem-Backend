package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.AppRecordDto;


public interface AppRecordService {
    public Long createAppRecord(AppRecordDto request);
    void updateRecord(AppRecordDto request);
    AppRecordDto getAppRecordByAppointmentID(Long appointmentI);
    AppRecordDto getRecordById(Long recordId);


}
