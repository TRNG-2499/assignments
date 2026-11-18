SELECT d.first_name, d.last_name from 
    Doctor d left join Appointment a on d.doctor_id = a.doctor_id 
    Where a.appointment_id IS NULL;

SELECT d.first_name, d.last_name from 
    Doctor d left join Appointment a on d.doctor_id = a.doctor_id 
    AND a.status = 'Scheduled'
    Where a.appointment_id IS NULL;