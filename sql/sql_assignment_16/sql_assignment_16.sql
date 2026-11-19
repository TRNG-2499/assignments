-- Doctor names with no appointments at all
select d.first_name, d.last_name
from doctor as d
left join appointment as a
on d.doctor_id = a.doctor_id
where a.appointment_id is null;

-- Doctor names with no schedules appointments
select d.first_name, d.last_name
from doctor as d
left join appointment as a
on d.doctor_id = a.doctor_id
where a.appointment_id is null or a.status = 'Completed';