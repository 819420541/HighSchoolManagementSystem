/*
Navicat MySQL Data Transfer

Source Server         : XuSihan
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : hzguigu

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-02-28 20:11:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `achievements`
-- ----------------------------
DROP TABLE IF EXISTS `achievements`;
CREATE TABLE `achievements` (
  `AchievementID` int(4) NOT NULL auto_increment,
  `ExamPlanID` int(4) default NULL,
  `ExamID` int(4) default NULL,
  `StudentID` int(4) default NULL,
  `Result` varchar(50) default NULL,
  PRIMARY KEY  (`AchievementID`),
  KEY `FK_Reference_24` (`ExamPlanID`),
  KEY `FK_Reference_25` (`ExamID`),
  KEY `FK_Reference_35` (`StudentID`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`ExamPlanID`) REFERENCES `examplans` (`ExamPlanID`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`ExamID`) REFERENCES `exams` (`ExamID`),
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`StudentID`) REFERENCES `studentsbase` (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of achievements
-- ----------------------------
INSERT INTO `achievements` VALUES ('1', '2', '2', '1', '80');
INSERT INTO `achievements` VALUES ('2', '1', '1', '1', '96');

-- ----------------------------
-- Table structure for `actions`
-- ----------------------------
DROP TABLE IF EXISTS `actions`;
CREATE TABLE `actions` (
  `ActionId` int(4) NOT NULL auto_increment,
  `ClassID` int(4) default NULL,
  `ActionName` varchar(50) default NULL,
  `ActionDate` datetime default NULL,
  `BeginTime` varchar(50) default NULL,
  `EndTime` varchar(50) default NULL,
  `Purpose` varchar(500) default NULL,
  PRIMARY KEY  (`ActionId`),
  KEY `FK_Reference_23` (`ClassID`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`ClassID`) REFERENCES `classes` (`ClassID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of actions
-- ----------------------------
INSERT INTO `actions` VALUES ('1', '2', '1234', '2018-02-04 00:00:00', '', '', '');
INSERT INTO `actions` VALUES ('2', '1', '321', '2018-02-05 00:00:00', '8：00', '10：00', '123');

-- ----------------------------
-- Table structure for `attendances`
-- ----------------------------
DROP TABLE IF EXISTS `attendances`;
CREATE TABLE `attendances` (
  `AttendanceID` int(4) NOT NULL auto_increment,
  `StudentID` int(4) default NULL,
  `ClassID` int(4) default NULL,
  `SemesterID` int(4) default NULL,
  `CourseID` int(4) default NULL,
  `Situation` varchar(50) default NULL,
  `AttendanceTime` datetime default NULL,
  `AttendanceDesc` varchar(255) default NULL,
  PRIMARY KEY  (`AttendanceID`),
  KEY `FK_Reference_26` (`StudentID`),
  KEY `FK_Reference_27` (`ClassID`),
  KEY `FK_Reference_29` (`SemesterID`),
  KEY `FK_Reference_30` (`CourseID`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`StudentID`) REFERENCES `studentsbase` (`StudentID`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`ClassID`) REFERENCES `classes` (`ClassID`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`SemesterID`) REFERENCES `semesters` (`SemesterID`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendances
-- ----------------------------
INSERT INTO `attendances` VALUES ('1', '1', '2', '1', '2', '请假', '2018-02-06 00:00:00', '已批准');

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `ClassID` int(4) NOT NULL auto_increment,
  `SchoolID` int(4) default NULL,
  `SemesterID` int(4) default NULL,
  `ClassName` varchar(50) default NULL,
  `TeacherOfCharge` varchar(50) default NULL,
  `EnrollmentDate` date default NULL,
  `GraduateDate` date default NULL,
  `isGraduate` bit(1) default NULL,
  `ClassState` int(4) default NULL,
  PRIMARY KEY  (`ClassID`),
  KEY `FK_Reference_14` (`SchoolID`),
  KEY `FK_Reference_16` (`SemesterID`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`SchoolID`) REFERENCES `schools` (`SchoolID`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`SemesterID`) REFERENCES `semesters` (`SemesterID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1', '1', 'J2001', '张三', '2015-02-08', '2018-01-29', '', '1');
INSERT INTO `classes` VALUES ('2', '1', '2', 'J2002', '李四', '2018-02-07', '2019-02-05', '', '1');

-- ----------------------------
-- Table structure for `control`
-- ----------------------------
DROP TABLE IF EXISTS `control`;
CREATE TABLE `control` (
  `ID` int(4) NOT NULL auto_increment,
  `CourseBookID` int(4) default NULL,
  `ProjectID` int(4) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_19` (`CourseBookID`),
  KEY `FK_Reference_20` (`ProjectID`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`CourseBookID`) REFERENCES `coursebooks` (`CourseBookID`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`ProjectID`) REFERENCES `projects` (`ProjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CourseID` int(4) NOT NULL auto_increment,
  `SchoolID` int(4) default NULL,
  `SemesterID` int(4) default NULL,
  `CourseBookID` int(4) default NULL,
  `CourseName` varchar(50) default NULL,
  `CourseState` int(4) default NULL,
  PRIMARY KEY  (`CourseID`),
  KEY `FK_Reference_18` (`SchoolID`),
  KEY `FK_Reference_21` (`SemesterID`),
  KEY `FK_Reference_28` (`CourseBookID`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`SchoolID`) REFERENCES `schools` (`SchoolID`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`SemesterID`) REFERENCES `semesters` (`SemesterID`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`CourseBookID`) REFERENCES `coursebooks` (`CourseBookID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1', '1', '1', '数学', '1');
INSERT INTO `course` VALUES ('2', '2', '2', '2', '汉文学', '1');

-- ----------------------------
-- Table structure for `coursebooks`
-- ----------------------------
DROP TABLE IF EXISTS `coursebooks`;
CREATE TABLE `coursebooks` (
  `CourseBookID` int(4) NOT NULL auto_increment,
  `CourseBookName` varchar(50) default NULL,
  `CourseBookCode` varchar(50) default NULL,
  `CourseBookDesc` varchar(50) default NULL,
  `TheoryPeriod` int(4) default NULL,
  `PracticePeriod` int(4) default NULL,
  `Knowledge` varchar(200) default NULL,
  `Suggestion` varchar(200) default NULL,
  `CourseBookState` int(4) default NULL,
  PRIMARY KEY  (`CourseBookID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursebooks
-- ----------------------------
INSERT INTO `coursebooks` VALUES ('1', '数学分析', 'shuxuefenxi', '数学分析简介', '32', '32', '数学分析主要知识点', '数学分析建议', '1');
INSERT INTO `coursebooks` VALUES ('2', '古诗词鉴赏', 'gushicijianshang', '古诗词鉴赏教材简介', '32', '16', '古诗词鉴赏主要知识', '古诗词鉴赏相关建议', '1');

-- ----------------------------
-- Table structure for `examplans`
-- ----------------------------
DROP TABLE IF EXISTS `examplans`;
CREATE TABLE `examplans` (
  `ExamPlanID` int(4) NOT NULL auto_increment,
  `ExamPlanName` varchar(50) default NULL,
  `ExamID` int(4) default NULL,
  `ClassID` int(4) default NULL,
  `ExamDate` datetime default NULL,
  `ExamStartTime` varchar(50) default NULL,
  `ExamEndTime` varchar(50) default NULL,
  `Remark` varchar(500) default NULL,
  `ExamPlanState` int(4) default NULL,
  PRIMARY KEY  (`ExamPlanID`),
  KEY `FK_Reference_22` (`ExamID`),
  KEY `FK_Reference_34` (`ClassID`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`ExamID`) REFERENCES `exams` (`ExamID`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`ClassID`) REFERENCES `classes` (`ClassID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examplans
-- ----------------------------
INSERT INTO `examplans` VALUES ('1', '数学考试安排', '1', '2', '2018-02-05 00:00:00', '13：00', '14：00', '注意考场纪律', '1');
INSERT INTO `examplans` VALUES ('2', '语文期末考试', '2', '1', '2018-02-10 00:00:00', '15：00', '17：00', '注意考场纪律', '1');

-- ----------------------------
-- Table structure for `exams`
-- ----------------------------
DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams` (
  `ExamID` int(4) NOT NULL auto_increment,
  `ExamTypeID` int(4) default NULL,
  `SchoolID` int(4) default NULL,
  `SemesterID` int(4) default NULL,
  `ExamName` varchar(50) default NULL,
  `ExamMedium` varchar(50) default NULL,
  `Remark` varchar(500) default NULL,
  `ExamState` int(4) default NULL,
  PRIMARY KEY  (`ExamID`),
  KEY `FK_Reference_31` (`ExamTypeID`),
  KEY `FK_Reference_32` (`SchoolID`),
  KEY `FK_Reference_33` (`SemesterID`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`ExamTypeID`) REFERENCES `examtypes` (`ExamTypeID`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`SchoolID`) REFERENCES `schools` (`SchoolID`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`SemesterID`) REFERENCES `semesters` (`SemesterID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exams
-- ----------------------------
INSERT INTO `exams` VALUES ('1', '1', '2', '1', '数学', '笔试', '要及格哦', '1');
INSERT INTO `exams` VALUES ('2', '2', '1', '1', '语文', '321', '123', '1');
INSERT INTO `exams` VALUES ('3', '2', '1', '2', '123', '', '', '0');
INSERT INTO `exams` VALUES ('5', '1', '2', '1', '43', '2321', '123', '0');

-- ----------------------------
-- Table structure for `examtypes`
-- ----------------------------
DROP TABLE IF EXISTS `examtypes`;
CREATE TABLE `examtypes` (
  `ExamTypeID` int(4) NOT NULL auto_increment,
  `SchoolID` int(4) default NULL,
  `ExamTypeName` varchar(50) default NULL,
  `remark` varchar(500) default NULL,
  `ExamTypeState` int(4) default NULL,
  PRIMARY KEY  (`ExamTypeID`),
  KEY `FK_Reference_17` (`SchoolID`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`SchoolID`) REFERENCES `schools` (`SchoolID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examtypes
-- ----------------------------
INSERT INTO `examtypes` VALUES ('1', '1', 'Java', null, '1');
INSERT INTO `examtypes` VALUES ('2', '1', 'C++', null, '1');

-- ----------------------------
-- Table structure for `projects`
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ProjectID` int(4) NOT NULL auto_increment,
  `ProjectName` varchar(50) default NULL,
  `ProjectPeriod` int(4) default NULL,
  `CodeMeasure` int(4) default NULL,
  `ProjectLevel` varchar(50) default NULL,
  `ProjectDesc` varchar(200) default NULL,
  `Difficulty` varchar(200) default NULL,
  `Target` varchar(200) default NULL,
  `Technique` varchar(200) default NULL,
  `ProjectDataBase` varchar(200) default NULL,
  `Conditions` varchar(200) default NULL,
  `Features` varchar(200) default NULL,
  `SkillDifficulty` varchar(200) default NULL,
  `SkillKeynote` varchar(200) default NULL,
  `Suggestion` varchar(200) default NULL,
  `ProjectState` int(4) default NULL,
  PRIMARY KEY  (`ProjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------

-- ----------------------------
-- Table structure for `schools`
-- ----------------------------
DROP TABLE IF EXISTS `schools`;
CREATE TABLE `schools` (
  `SchoolID` int(4) NOT NULL auto_increment,
  `SchoolName` varchar(50) default NULL,
  `SchoolState` int(4) default NULL,
  PRIMARY KEY  (`SchoolID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schools
-- ----------------------------
INSERT INTO `schools` VALUES ('1', '杭州电子科技大学', '1');
INSERT INTO `schools` VALUES ('2', '浙江理工大学', '1');

-- ----------------------------
-- Table structure for `semesters`
-- ----------------------------
DROP TABLE IF EXISTS `semesters`;
CREATE TABLE `semesters` (
  `SemesterID` int(4) NOT NULL auto_increment,
  `SemesterName` varchar(50) default NULL,
  `SemesterState` int(4) default NULL,
  PRIMARY KEY  (`SemesterID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of semesters
-- ----------------------------
INSERT INTO `semesters` VALUES ('1', '2018年第一学期', '1');
INSERT INTO `semesters` VALUES ('2', '2018年第二学期', '1');

-- ----------------------------
-- Table structure for `studentcontact`
-- ----------------------------
DROP TABLE IF EXISTS `studentcontact`;
CREATE TABLE `studentcontact` (
  `StudentContactID` int(4) NOT NULL auto_increment,
  `StudentID` int(4) default NULL,
  `Homeaddress` varchar(50) default NULL,
  `Family` varchar(50) default NULL,
  `Phone` varchar(50) default NULL,
  `Mobilephone` varchar(50) default NULL,
  `Email` varchar(50) default NULL,
  `Others` varchar(50) default NULL,
  PRIMARY KEY  (`StudentContactID`),
  KEY `FK_Reference_13` (`StudentID`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`StudentID`) REFERENCES `studentsbase` (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentcontact
-- ----------------------------
INSERT INTO `studentcontact` VALUES ('1', '1', '浙江', '父亲', '25809583', '1886883465', '734956385@qq.com', '无');
INSERT INTO `studentcontact` VALUES ('2', '2', null, null, null, null, null, null);
INSERT INTO `studentcontact` VALUES ('3', '3', null, null, null, null, null, null);
INSERT INTO `studentcontact` VALUES ('4', '4', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `studentsbase`
-- ----------------------------
DROP TABLE IF EXISTS `studentsbase`;
CREATE TABLE `studentsbase` (
  `StudentID` int(4) NOT NULL auto_increment,
  `ClassID` int(4) default NULL,
  `SchoolID` int(4) default NULL,
  `StudentName` varchar(50) default NULL,
  `NameSpell` varchar(50) default NULL,
  `Birthday` datetime default NULL,
  `IdentityCard` varchar(18) default NULL,
  `Sex` varchar(2) default NULL,
  `Nation` varchar(50) default NULL,
  `Education` varchar(50) default NULL,
  `Dwellingplace` varchar(50) default NULL,
  `Nativeplace` varchar(50) default NULL,
  `Photo` varchar(300) default NULL,
  `StudentState` int(4) default NULL,
  PRIMARY KEY  (`StudentID`),
  KEY `FK_Reference_12` (`ClassID`),
  KEY `FK_Reference_36` (`SchoolID`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`ClassID`) REFERENCES `classes` (`ClassID`),
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`SchoolID`) REFERENCES `schools` (`SchoolID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentsbase
-- ----------------------------
INSERT INTO `studentsbase` VALUES ('1', '1', '1', '关羽', 'guanyu', '2006-02-06 00:00:00', '330902198904025673', '男', '汉', '高中', '杭州', '浙江舟山', null, '1');
INSERT INTO `studentsbase` VALUES ('2', '1', '2', '刘备', 'liubei', '1994-10-01 00:00:00', '', '', '', '', '', '', null, '1');
INSERT INTO `studentsbase` VALUES ('3', '1', '2', '张飞', 'zhangfei', null, '', '', '', '', '', '', null, '1');
INSERT INTO `studentsbase` VALUES ('4', '1', '1', '黄忠', 'huangzhong', '2018-02-14 00:00:00', '', '', '', '', '', '', null, '1');

-- ----------------------------
-- Table structure for `studentstudyrecord`
-- ----------------------------
DROP TABLE IF EXISTS `studentstudyrecord`;
CREATE TABLE `studentstudyrecord` (
  `StudyRecordID` int(4) NOT NULL auto_increment,
  `StudentID` int(4) default NULL,
  `ComputerLevel` varchar(50) default NULL,
  `EnglishLevel` varchar(50) default NULL,
  `GraduateSchool` varchar(50) default NULL,
  `GraduteTime` datetime default NULL,
  `Certificate` varchar(50) default NULL,
  `JobCompany` varchar(50) default NULL,
  `JobCourse` varchar(500) default NULL,
  PRIMARY KEY  (`StudyRecordID`),
  KEY `FK_Reference_15` (`StudentID`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`StudentID`) REFERENCES `studentsbase` (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentstudyrecord
-- ----------------------------
INSERT INTO `studentstudyrecord` VALUES ('1', '1', '二级', '四级', '杭电', '2017-01-20 00:00:00', '计算机等级考试', '1', '2');
INSERT INTO `studentstudyrecord` VALUES ('2', '2', '二级', '六级', '', null, '', '', '');
INSERT INTO `studentstudyrecord` VALUES ('3', '3', null, null, null, null, null, null, null);
INSERT INTO `studentstudyrecord` VALUES ('4', '4', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `userslogin`
-- ----------------------------
DROP TABLE IF EXISTS `userslogin`;
CREATE TABLE `userslogin` (
  `Account` varchar(16) NOT NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY  (`Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userslogin
-- ----------------------------
INSERT INTO `userslogin` VALUES ('admin', '123456');
