DROP DATABASE IF EXISTS DreamHome;
CREATE DATABASE DreamHome;
USE DreamHome;

CREATE TABLE PropertyForRent (
    PropertyNr int(3) PRIMARY KEY,
    OwnerNr int(3),
    Address char(20),
    Area char(20),
    City char(20),
    Postcode char(6),
    Type char(15),
    RoomsNr int(2),
    MonthsRent int(3)
);
   
CREATE TABLE Owner (
    OwnerID int(3) PRIMARY KEY,
    Address char(20),
    TellNr int(10)
);

CREATE TABLE BusinessOwner (
    OwnerID int(3),
    ContactName char(15),
    BusinessType char(15)
);

CREATE TABLE PrivateOwner (
    OwnerID int(3),
    FirstName char(15),
    LastName char(15)
);

ALTER TABLE PrivateOwner
    ADD FOREIGN KEY (OwnerID)
        REFERENCES Owner(OwnerID)
        ON UPDATE CASCADE
        ON DELETE CASCADE;
        
ALTER TABLE BusinessOwner
    ADD FOREIGN KEY (OwnerID)
        REFERENCES Owner(OwnerID)
        ON UPDATE CASCADE
        ON DELETE CASCADE;
        
/*
Werkt alleen wanneer hij PropertyNr referenced 
ALTER TABLE Owner 
    ADD FOREIGN KEY (Address)
        REFERENCES  PropertyForRent(Address);
*/

CREATE TABLE Viewing (
    PropertyNr int(3),
    ClientNr int(3),
    ViewDate char(8),
    Comments char(150)
);

CREATE TABLE Advert (
    PropertyNr int(3),
    PaperNr int(2),
    AdDate char(8),
    Cost int(3)
);

CREATE TABLE NewsPaper (
    PaperNr int(2) PRIMARY KEY,
    Address char(20),
    TellNr int(10),
    Email char(25),
    ContactName char(15)
);

ALTER TABLE Advert
    ADD FOREIGN KEY (PropertyNr)
        REFERENCES PropertyForRent(PropertyNr)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE TABLE Inspection (
    PropertyNr int(3),
    StaffNr int(3),
    inspectionDate char(8),
    Comments char(150)
);

ALTER TABLE Inspection
    ADD FOREIGN KEY (PropertyNr)
        REFERENCES PropertyForRent(PropertyNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

CREATE TABLE Staff (
    StaffNr int(3) PRIMARY KEY, 
    BranchNr int(2),
    FirstName char(15),
    LastName char(15),
    Address char(15),
    TellNr int(10),
    Sex char(1),
    DateOfBirth char(15),
    NIN char(15),
    Salary int(5),
    JointDate char(8)
);

ALTER TABLE Inspection
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
CREATE TABLE Secretary (
    StaffNr int(3),
    TypingSpeed int(4)
);

ALTER TABLE Secretary
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;  
        
CREATE TABLE Manager (
    StaffNr int(3),
    BranchNr int(2),
    DataManager char(8),
    CarAllowance char(10),
    BonusPayment char(5)
);

ALTER TABLE Manager
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
CREATE TABLE Relative (
    StaffNr int(3) PRIMARY KEY,
    FirstName char(15),
    LastName char(15),
    Address char(15),
    Postcode char(15),
    City char(15),
    TelephoneNr int(10),
    Relationship char(15)
);

ALTER TABLE Relative
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

CREATE TABLE Branch (
    BranchNr int(2) PRIMARY KEY,
    ManagerNr int(3),
    Address char(15),
    Area char(15),
    City char(15),
    Postcode char(15),
    TellNr int(10),
    email char(15)
);

ALTER TABLE Staff
    ADD FOREIGN KEY (BranchNr)
        REFERENCES Branch(BranchNr)
        ON UPDATE CASCADE
        ON DELETE RESTRICT;
        
ALTER TABLE Manager
    ADD FOREIGN KEY (BranchNr)
        REFERENCES Branch(BranchNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

CREATE TABLE Client (
    ClientNr int(3) PRIMARY KEY,
    FirstName char(15),
    LastName char(15),
    TellNr int(10),
    PrefType char(15),
    MaxRent int(4)
);

ALTER TABLE Viewing
    ADD FOREIGN KEY (PropertyNr)
        REFERENCES PropertyForRent(PropertyNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
ALTER TABLE Viewing
    ADD FOREIGN KEY (ClientNr)
        REFERENCES Client(ClientNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
CREATE TABLE Interview (
    StaffNr int(3),
    ClientNr int(3),
    InterviewDate char(8),
    Comments char(150)
);

ALTER TABLE Interview
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
ALTER TABLE Interview
    ADD FOREIGN KEY (ClientNr)
        REFERENCES Client(ClientNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

CREATE TABLE LeaseAgreement (
    StaffNr int(3),
    ClientNr int(3),
    PropertyNr int(3),
    StartDate char(8),
    Duration char(15),
    Rent int(4),
    PaymentMethod char(15),
    Deposit int(3),
    DepositPaid int(1)
);

ALTER TABLE LeaseAgreement
    ADD FOREIGN KEY (StaffNr)
        REFERENCES Staff(StaffNr)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;
        
ALTER TABLE LeaseAgreement
    ADD FOREIGN KEY (ClientNr)
        REFERENCES Client(ClientNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;
        
ALTER TABLE LeaseAgreement
    ADD FOREIGN KEY (PropertyNr)
        REFERENCES PropertyForRent(PropertyNr)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


        
        

