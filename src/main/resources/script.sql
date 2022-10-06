-- SQL Script

-- Details
INSERT INTO `curso_ayi_final`.`details` VALUES
    (1, 45800, 0),
    (2, 20155, 1),
    (3, 844, 1),
    (4, 10090, 0),
    (5, 900, 1),
    (6, 49060, 0),
    (7, 154000, 1),
    (8, 45110, 0),
    (9, 14600, 0),
    (10, 37000, 0);

-- Clients
INSERT INTO `curso_ayi_final`.`clients` (`id_client`, `dni`, `first_name`, `last_name`, `details_fk`) VALUES -- is_active attribute is "true" by default
    (1, '39076703', 'Germán', 'Furfori', 1),
    (2, '40521326', 'Juan Cruz', 'Nieto', 2),
    (3, '25457965', 'Silvia', 'Otaka', 3),
    (4, '36222154', 'Juan Ignacio', 'Caballero', 4),
    (5, '35216548', 'Gimena', 'Binaghi', 5),
    (6, '34521258', 'Fernanda', 'Balduzzi', 6),
    (7, '39658547', 'Leonel', 'Altamirano', 7),
    (8, '38546921', 'Nicolas', 'Clemente', 8),
    (9, '39456182', 'Rodrigo', 'Egea', 9),
    (10, '34251888', 'Josias', 'Pazzelli', 10);

-- Invoices
INSERT INTO `curso_ayi_final`.`invoices` VALUES
    (1, "Cubiertas MAXXIS Crossmark rod 29 X2", 17500, 1),
    (2, "Caja Shimano Hollowtech", 22500, 1),
    (3, "Plato palanca Shimano Deore M4100", 19890, 1),
    (4, "Casco Bern Lenox", 4500, 2),
    (5, "Horquilla Cannondale Lefty", 32500, 2),
    (6, "Bicicleta Zenith Riva Elite rod 29 1x12", 287489, 3),
    (7, "Puños MTB Raleigh", 860, 4),
    (8, "Cámara 29x190", 1300, 4),
    (9, "Inflador Bulit serie 600", 7665, 5),
    (10, "Descarrilador Shimano Tourney", 2139, 5),
    (11, "Shifters Shimano Tourney 3x8", 8685, 5),
    (12, "Inflador Bulit serie 600", 7665, 6),
    (13, "Bicicleta Cannondale Trail 5", 402777, 7),
    (14, "Manubrio MTB Zoom", 5490, 8),
    (15, "Asiento Velo Race MTB", 8490, 10),
    (16, "Cadena cementada c/candado BULIT", 6590, 10);

-- Addresses
INSERT INTO `curso_ayi_final`.`addresses` VALUES
    (1, "Castelar", "Argentina", NULL, NULL, "938", "Buenos Aires", "Buenos Aires", "B1712", 1),
    (2, "Castelar", "Argentina", NULL, NULL, "3095", "Buenos Aires", "Diego Araoz", "B1712", 1),
    (3, "Ciudadela", "Argentina", 8, "B", "121", "Buenos Aires", "Padre Elizalde", "B1701", 2),
    (4, "Rosario", "Argentina", NULL, NULL, "125", "Santa Fé", "Zapiola", "S2000", 3),
    (5, "Rosario", "Argentina", NULL, NULL, "8845", "Santa Fé", "Manuel Prudan", "S2001", 3),
    (6, "San Rafael", "Argentina", NULL, NULL, "2548", "Mendoza", "San Martín", "M5600", 4),
    (7, "Mendoza", "Argentina", NULL, NULL, "548", "Mendoza", "Ocampo", "M5500", 4),
    (8, "Las Toscas", "Argentina", NULL, NULL, "22", "Santa Fé", "Belgrano", "15200", 5),
    (9, "Córdoba Capital", "Argentina", NULL, NULL, "8541", "Córdoba", "Av. Libertador", "B5000", 6),
    (10, "Córdoba Capital", "Argentina", NULL, NULL, "552", "Córdoba", "Etchegaray", "B5002", 6),
    (11, "Alta Gracia", "Argentina", NULL, NULL, "369", "Córdoba", "Olazabal", "X5186", 7),
    (12, "Paraná", "Argentina", 5, "A", "226", "Entre Ríos", "Juncal", "E3100", 8),
    (13, "Calafate", "Argentina", NULL, NULL, "5961", "Santa Cruz", "Martín Fierro", "Z9405", 9),
    (14, "Puerto Pirámides", "Argentina", NULL, NULL, "778", "Chubut", "1006", "U9121", 10);