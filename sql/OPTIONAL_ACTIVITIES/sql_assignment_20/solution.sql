-- 1. Show every Introductory SQL attempt, highest score first.
-- CASE controls the displayed name while keeping the ID and score visible.


SELECT s.student_id,
       CASE
           WHEN e.test_score >= t.pass_mark THEN s.student_name
           ELSE NULL
       END AS student_name,
       e.test_score
FROM TestEvent e
JOIN Student s ON s.student_id = e.student_id
JOIN TestConfig t ON t.test_id = e.test_id
WHERE t.test_name = 'Introductory SQL'
ORDER BY e.test_score DESC, e.event_id;

-- Stretch. Show all attempts using each test's own pass mark.
SELECT s.student_id,
       CASE
           WHEN e.test_score >= t.pass_mark THEN s.student_name
           ELSE NULL
       END AS student_name,
       t.test_name,
       e.test_score
FROM TestEvent e
JOIN Student s ON s.student_id = e.student_id
JOIN TestConfig t ON t.test_id = e.test_id
ORDER BY t.test_name, e.test_score DESC, e.event_id;