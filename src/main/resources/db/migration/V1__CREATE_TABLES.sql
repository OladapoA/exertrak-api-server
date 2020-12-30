-- CREATE SCHEMA IF NOT EXISTS migrations;

CREATE TABLE public.users
-- CREATE TABLE IF NOT EXISTS migrations.users
(
    user_id     SERIAL PRIMARY KEY,
    first_name  varchar(30) NOT NULL,
    last_name   varchar(30) NOT NULL
);

CREATE TABLE public.routines
-- CREATE TABLE IF NOT EXISTS migrations.routines
(
    routine_id  SERIAL PRIMARY KEY,
    user_id     int NOT NULL REFERENCES users (user_id),
    is_public   boolean NOT NULL,
    name        varchar(30) NOT NULL,
    description text,
    created_at  timestamp NOT NULL
);

CREATE TABLE public.exercises
-- CREATE TABLE IF NOT EXISTS migrations.exercises
(
    exercise_id       SERIAL PRIMARY KEY,
    user_id           int NOT NULL REFERENCES users (user_id),
    variation_parent  int REFERENCES exercises (exercise_id),
    name              varchar(30),
    description       text
);

CREATE TABLE public.routine_exercises
-- CREATE TABLE IF NOT EXISTS migrations.routine_exercises
(
    routine_exercise_id SERIAL PRIMARY KEY,
    routine_id  int NOT NULL REFERENCES routines (routine_id),
    exercise_id int NOT NULL REFERENCES exercises (exercise_id),
    sets        int,
    set_break   time,
    reps        int,
    rep_break   time,
    time        time
);

CREATE TABLE public.muscle_groups
-- CREATE TABLE IF NOT EXISTS migrations.muscle_groups
(
    muscle_group_id SERIAL PRIMARY KEY,
    major_name  varchar(30) NOT NULL,
    minor_name  varchar(30)
);

CREATE TABLE public.exercise_muscle_groups
-- CREATE TABLE IF NOT EXISTS migrations.exercise_muscle_groups
(
    exercise_id     int NOT NULL REFERENCES exercises (exercise_id),
    muscle_group_id int NOT NULL REFERENCES muscle_groups (muscle_group_id)
);