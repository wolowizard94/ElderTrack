package eldertrack.login;

public enum AccessLevel {
		NOACCESS, 	// Not allowed to login DB Level: 0
		JRSTAFF, 	// Use features only for checking DB Level: 1
		STAFF, 		// Allowed to edit Diet and Med DB Level: 2
		SRSTAFF, 	// Allowed to edit elderly profiles on Management DB Level: 3
		MANAGER; 	// Allowed to edit staff profiles on Management DB Level: 4
}
