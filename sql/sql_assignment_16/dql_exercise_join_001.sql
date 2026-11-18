SELECT Doctor.first_name, Doctor.last_name FROM Doctor
WHERE Doctor.doctor_id NOT IN (
    SELECT Appointment.doctor_id FROM Appointment
);