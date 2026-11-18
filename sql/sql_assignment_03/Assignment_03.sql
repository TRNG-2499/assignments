 Alter Table if exists part.writer rename to Author;

 Alter Table if exists part.author rename column writer_id to author_id;

  Alter Table if exists part.author rename column writer_name to author_name;