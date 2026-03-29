const express = require('express');
const cors = require('cors');
const mysql = require('mysql2');

const app = express();
const PORT = 3000; 

// Middleware
app.use(cors());
app.use(express.json());

// --- CONFIGURACIÓN DE LA BASE DE DATOS ---
const db = mysql.createPool({
  host: 'localhost',
  user: 'root',
  password: 'Holajuan12#', // Tu contraseña de MySQL
  database: 'crud_db',      // Tu base de datos de Spring Boot
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0
});

// Verificar conexión inicial
db.getConnection((err, connection) => {
  if (err) {
    console.error(' Error: No se pudo conectar a MySQL.', err.message);
  } else {
    console.log(' Node.js conectado a "crud_db" (Tabla: tbl_student)');
    connection.release();
  }
});

// ==========================================
//           RUTAS CRUD (API REST)
// ==========================================

// 1. LISTAR TODOS (GET) - IMPORTANTE: Usamos "AS" para que Angular vea los datos
app.get('/students', (req, res) => {
  const query = `
    SELECT 
      id, 
      first_name AS firstName, 
      last_name AS lastName, 
      email, 
      mobile_number AS mobileNumber 
    FROM tbl_student
  `; 
  
  db.query(query, (err, results) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(results); // Ahora los datos viajan como firstName, lastName, etc.
  });
});

// 2. CREAR (POST)
app.post('/students', (req, res) => {
  const { firstName, lastName, email, mobileNumber } = req.body;
  const query = 'INSERT INTO tbl_student (first_name, last_name, email, mobile_number) VALUES (?, ?, ?, ?)';
  
  db.query(query, [firstName, lastName, email, mobileNumber], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.status(201).json({ id: result.insertId, ...req.body });
  });
});

// 3. ACTUALIZAR (PUT)
app.put('/students/:id', (req, res) => {
  const { id } = req.params;
  const { firstName, lastName, email, mobileNumber } = req.body;
  const query = 'UPDATE tbl_student SET first_name = ?, last_name = ?, email = ?, mobile_number = ? WHERE id = ?';
  
  db.query(query, [firstName, lastName, email, mobileNumber, id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: 'Estudiante actualizado' });
  });
});

// 4. ELIMINAR (DELETE)
app.delete('/students/:id', (req, res) => {
  const { id } = req.params;
  const query = 'DELETE FROM tbl_student WHERE id = ?';
  
  db.query(query, [id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: 'Estudiante eliminado' });
  });
});

// --- INICIAR SERVIDOR ---
app.listen(PORT, () => {
  console.log(` Servidor Node.js activo en http://localhost:${PORT}`);
  console.log(` Esperando peticiones de Angular...`);
});