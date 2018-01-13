CREATE TABLE Trace
(
	trace_id INTEGER NOT NULL AUTO_INCREMENT,
	project_name VARCHAR(255),
	project_version VARCHAR(255),
	launch_class VARCHAR(255),
	launch_method VARCHAR(255),
	generated_time TIMESTAMP,
	is_multithread INTEGER,
	PRIMARY KEY (trace_id)
) 
;


