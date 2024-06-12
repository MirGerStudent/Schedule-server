BEGIN;
CREATE TABLE IF NOT EXISTS "groups" (
    "group_id" varchar(128) PRIMARY KEY,
    "group_name" varchar(16) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS "students" (
    "student_id" varchar(128) PRIMARY KEY,
    "student_surname" varchar(32) NOT NULL,
    "student_name" varchar(32) NOT NULL,
    "student_patronymic" varchar(32),
    "student_status" varchar(32) NOT NULL,
    "group_id" varchar(128),
    FOREIGN KEY ("group_id") REFERENCES "groups" ("group_id") ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS "teachers" (
    "teacher_id" varchar(128) PRIMARY KEY,
    "teacher_surname" varchar(32) NOT NULL,
    "teacher_name" varchar(32) NOT NULL,
    "teacher_patronymic" varchar(32),
    "teacher_position" varchar(32) NOT NULL
);
COMMIT;