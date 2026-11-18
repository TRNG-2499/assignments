SELECT first_name, last_name FROM Doctor
LEFT JOIN Appointment
    ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.appointment_id IS NULL;

-- Stretch -- not complete

SELECT first_name, last_name FROM Doctor
LEFT JOIN Appointment
    ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.appointment_id IS NULL
    AND Appointment.status != 'Scheduled';