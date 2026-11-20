/*
Given the following tables, provide an SQL statement
that returns the names of all doctors who have no appointments 
at all in the Appointment table.

*Note: for this query, treat any row in the Appointment table as
an appointment regardless of its status.*

**Stretch Goal:** Add a second query that returns the names of all
doctors who have no **currently scheduled** appointments. 
*Note: this will require filtering on `status`.*
*/

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
ON d.doctor_id = a.doctor_id
WHERE a.doctor_id IS NULL;

--STRETCH GOAL

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
    ON d.doctor_id = a.doctor_id
    AND a.status = 'Scheduled'
WHERE a.doctor_id IS NULL;

