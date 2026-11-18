SELECT doctor_id, first_name, last_name, specialty FROM Doctor
LEFT JOIN Appointment ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.appointment_id IS NULL;