create database if not exists home;

use home;

-- 회원 정보 테이블
DROP TABLE IF EXISTS member;

CREATE TABLE IF NOT EXISTS `member` (
  `email_id` VARCHAR(100) NOT NULL,
  `pass` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(60) NOT NULL UNIQUE,
  `phone_number` VARCHAR(100) NOT NULL,
  `img_origin` VARCHAR(255) NOT NULL default "default_profile.jpg",
  `img_save` VARCHAR(255) NOT NULL default "default_profile.jpg",
  `join_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exit_date` TIMESTAMP,
  `last_login_date` TIMESTAMP,
  `status` ENUM('A', 'I', 'X') default 'A',
  `is_admin` BOOLEAN NOT NULL default false,
  PRIMARY KEY (`email_id`)
  )
  ENGINE = InnoDB;

insert into member(email_id, pass, name, nickname, phone_number, is_admin) 
values("soulb9@naver.com", "12341234", "이방환", "bang", "010-4129-6229", true);
insert into member(email_id, pass, name, nickname, phone_number, is_admin) 
values("kimssafy@ssafy.com", "12341234", "김소윤", "soyoon", "010-1234-5678", true);
insert into member(email_id, pass, name, nickname, phone_number, is_admin) 
values("sbcGOAT@ssafy.com", "12341234", "교수님", "대전의레전드", "010-8765-4321", true);

-- 게시판 테이블
DROP TABLE IF EXISTS board;

CREATE TABLE IF NOT EXISTS `board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `category` ENUM('local', 'share', 'notice', 'one_on_one') NOT NULL,
  `member_id` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(60) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `hit` INT NULL DEFAULT 0,
  `like` INT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP,
  PRIMARY KEY (`article_no`),
  CONSTRAINT `board_to_member_id_fk`
    FOREIGN KEY (`member_id`)
    REFERENCES member (`email_id`) ON DELETE CASCADE,
  CONSTRAINT `board_to_member_nickname_fk`
    FOREIGN KEY (`nickname`)
    REFERENCES member (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 댓글 테이블
DROP TABLE IF EXISTS comment;

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_no` INT NOT NULL AUTO_INCREMENT,
  `article_no` INT NOT NULL,
  `member_id` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(60) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `depth` INT NOT NULL DEFAULT 0,
  `parent_no` INT NOT NULL DEFAULT 0,
  `like` INT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP,
  PRIMARY KEY (`comment_no`),
  CONSTRAINT `board_to_article_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES board (`article_no`) ON DELETE CASCADE,
  CONSTRAINT `member_to_comment_id_fk`
    FOREIGN KEY (`member_id`)
    REFERENCES member (`email_id`) ON DELETE CASCADE,
  CONSTRAINT `member_to_comment_nickname_fk`
    FOREIGN KEY (`nickname`)
    REFERENCES member (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- 파일 저장정보 테이블 

DROP TABLE IF EXISTS fileinfo;

CREATE TABLE IF NOT EXISTS `fileinfo` (
  `save_name` VARCHAR(255) NOT NULL,
  `dst_path`  VARCHAR(255) NOT NULL,
  `origin_name` VARCHAR(255) NOT NULL,
  `article_no` INT NOT NULL,
  PRIMARY KEY (`save_name`),
  FOREIGN KEY (`article_no`) REFERENCES `home`.`board` (`article_no`)
) ENGINE = InnoDB;



-- local ////////////////////////////////
insert into board(category, member_id, nickname, title, content)
values('local', 'soulb9@naver.com', 'bang', 'local test', "안녕하세요이방환입니다.안녕하세요이방환입니다.안녕하세요이방환입니다.");
insert into board(category, member_id, nickname, title, content)
values('local', 'kimssafy@ssafy.com', 'soyoon', 'soyoon test local', "내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.");
insert into board(category, member_id, nickname, title, content)
values('local', 'sbcGOAT@ssafy.com', '대전의레전드', "who's the best? (local)", "local Do you know what GOAT means? It's great of all time and it's me!!");

-- share ////////////////////////////////
insert into board(category, member_id, nickname, title, content)
values('share', 'soulb9@naver.com', 'bang', 'share test', "안녕하세요이방환입니다.안녕하세요이방환입니다.안녕하세요이방환입니다.");
insert into board(category, member_id, nickname, title, content)
values('share', 'kimssafy@ssafy.com', 'soyoon', 'soyoon test share', "내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.");
insert into board(category, member_id, nickname, title, content)
values('share', 'sbcGOAT@ssafy.com', '대전의레전드', "who's the best? (share)", "share Do you know what GOAT means? It's great of all time and it's me!!");

-- notice ////////////////////////////////
insert into board(category, member_id, nickname, title, content)
values('notice', 'soulb9@naver.com', 'bang', 'notice test', "안녕하세요이방환입니다.안녕하세요이방환입니다.안녕하세요이방환입니다.");
insert into board(category, member_id, nickname, title, content)
values('notice', 'kimssafy@ssafy.com', 'soyoon', 'soyoon test notice', "내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.");
insert into board(category, member_id, nickname, title, content)
values('notice', 'sbcGOAT@ssafy.com', '대전의레전드', "who's the best? (notice)", "notice Do you know what GOAT means? It's great of all time and it's me!!");

-- one_on_one ////////////////////////////////
insert into board(category, member_id, nickname, title, content)
values('one_on_one', 'soulb9@naver.com', 'bang', 'one_on_one test', "안녕하세요이방환입니다.안녕하세요이방환입니다.안녕하세요이방환입니다.");
insert into board(category, member_id, nickname, title, content)
values('one_on_one', 'kimssafy@ssafy.com', 'soyoon', 'soyoon test one_on_one', "내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.내이름은 김소윤, 레전드지.");
insert into board(category, member_id, nickname, title, content)
values('one_on_one', 'sbcGOAT@ssafy.com', '대전의레전드', "who's the best? (share)", "Do you know what GOAT means? It's great of all time and it's me!!");
