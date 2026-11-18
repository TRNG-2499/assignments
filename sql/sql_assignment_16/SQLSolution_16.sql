SELECT d.first_name, d.last_name FROM assignment.doctor d LEFT JOIN 
assignment.appointment a ON d.doctor_id = a.doctor_id WHERE
a.appointment_id IS NULL;

SELECT d.first_name, d.last_name FROM assignment.doctor d LEFT JOIN 
assignment.appointment a ON d.doctor_id = a.doctor_id AND a.status ='Scheduled'
WHERE a.appointment_id IS NULL;