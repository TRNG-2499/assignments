-- BASE SQL QUERY
SELECT Doctor.first_name, Doctor.last_name
    FROM Doctor
        LEFT JOIN Appointment 
        ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.appointment_id IS NULL;

-- STRETCH SQL QUERY
SELECT Doctor.first_name, Doctor.last_name
    FROM Doctor
        LEFT JOIN Appointment 
        ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.status =  'Scheduled'
GROUP BY Doctor.doctor_id, Doctor.first_name, Doctor.last_name;