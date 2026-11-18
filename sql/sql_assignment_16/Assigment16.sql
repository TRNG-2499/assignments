select d.first_name, d.last_name from doctor 
d left join Appointment a on d.doctor_id = a.doctor_id 
where a.appointment_id is null;