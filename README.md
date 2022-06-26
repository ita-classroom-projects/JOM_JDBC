<p><span style="font-weight: normal;">Develop a database with tables <strong><span>Roles</span></strong>, <strong><span>Employee</span></strong>, <strong><span>Directions </span></strong>and <strong><span>Projects</span></strong>.<br></span>
</p>
<ol>
    <li><span style="font-weight: normal;">The <strong>Roles </strong>table contains the <strong><span>id </span></strong>(primary key), <strong><span>roleName</span></strong>.</span>
    </li>
    <li><span style="font-weight: normal;">The <strong>Directions </strong>table contains the <strong><span>id </span></strong>(primary key), <strong><span>directionName</span></strong>.</span>
    </li>
    <li><span style="font-weight: normal;">The <strong>Projects </strong>table contains <strong><span>id </span></strong>(primary key), <strong><span>projectName</span></strong>, <strong><span>directionId </span></strong>(foreign key).</span>
    </li>
    <li><span style="font-weight: normal;">The <strong>Employee </strong>table contains <strong><span>id </span></strong>(primary key), <strong><span>firstName</span></strong>, <strong><span>roleId </span></strong>(foreign key), <strong><span>projectId </span></strong>(foreign
            key).
        </span>
    </li>
</ol>
<p style="text-align: center;"><img src="https://softserve.academy/draftfile.php/91405/user/draft/954268972/db_sch.png" alt="" role="presentation" class="img-responsive atto_image_button_text-bottom" width="400"><br></p>
<p><span style="font-weight: normal;">Create next methods of the <strong>MyUtils </strong>class:</span><span style="font-weight: normal;"><br></span></p>
<div style="margin-left: 30px;" class="editor-indent">
    <p><code><span style="font-weight: normal; font-size:11pt">public Connection createConnection() throws SQLException<br>public void closeConnection() throws SQLException<br>public Statement createStatement() throws SQLException<br>public void closeStatement() throws SQLException<br>public void createSchema(String schemaName) throws SQLException<br>public void dropSchema() throws SQLException<br>public void useSchema() throws SQLException</span></code></p>
</div>
<p><span style="font-weight: normal;">Methods for creating tables:</span></p>
<div style="margin-left: 30px;" class="editor-indent">
    <p><code><span style="font-weight: normal; font-size:11pt">public void createTableRoles() throws SQLException<br>public void createTableDirections() throws SQLException<br>public void createTableProjects() throws SQLException<br>public void createTableEmployee() throws SQLException<br>public void dropTable(String tableName) throws SQLException</span></code></p>
</div>
<p><span style="font-weight: normal;">Methods for insert data to tables:</span></p>
<div style="margin-left: 30px;" class="editor-indent">
    <p><code><span style="font-weight: normal; font-size:11pt">public void insertTableRoles(String roleName) throws SQLException<br>public void insertTableDirections(String directionName) throws SQLException<br>public void insertTableProjects(String projectName, String directionName) throws SQLException<br>public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException</span></code></p>
</div>
<p><span style="font-weight: normal;">Methods to obtaining data from tables:</span></p>
<div style="margin-left: 30px;" class="editor-indent">
    <p><code><span style="font-weight: normal; font-size:11pt">public int getRoleId(String roleName) throws SQLException<br>public int getDirectionId(String directionName) throws SQLException<br>public int getProjectId(String projectName) throws SQLException<br>public int getEmployeeId(String firstName) throws SQLException<br>public List&lt;String&gt; getAllRoles() throws SQLException<br>public List&lt;String&gt; getAllDirestion() throws SQLException<br>public List&lt;String&gt; getAllProjects() throws SQLException<br>public List&lt;String&gt; getAllEmployee() throws SQLException<br>public List&lt;String&gt; getAllDevelopers() throws SQLException<br>public List&lt;String&gt; getAllJavaProjects() throws SQLException<br>public List&lt;String&gt; getAllJavaDevelopers() throws SQLException</span></code></p>
</div>
<p><span style="font-weight: normal;">For example, for a given data</span></p>
<p style="font-weight: normal; text-align: center;"><img src="https://softserve.academy/draftfile.php/91405/user/draft/954268972/db_dat.png" alt="" role="presentation" class="img-responsive atto_image_button_text-bottom" width="350"></p>

<p><span style="font-weight: normal;"><span>вы должны получить методом <strong>getAllJavaDevelopers()</strong> &nbsp; &nbsp; =&gt; &nbsp;&nbsp; <strong> [Ира, Иван, Петр]</strong> .</span></span>
</p>
