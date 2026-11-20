SELECT first_name, last_name, specialty FROM Doctor d
    LEFT JOIN appointment a ON a.doctor_id = d.doctor_id
    WHERE a.appointment_id IS NULL;
