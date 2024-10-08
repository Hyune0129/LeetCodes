# Write your MySQL query statement below
select Students.student_id, Students.student_name, Subjects.subject_name, count(Examinations.student_id) as attended_exams from (Students join Subjects)
left join Examinations on Examinations.student_id = Students.student_id and Examinations.subject_name = Subjects.subject_name
group by student_id, subject_name
order by student_id, subject_name;