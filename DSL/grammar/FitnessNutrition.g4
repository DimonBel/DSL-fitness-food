grammar FitnessNutrition;

// Parser Rules
program
    : statement*
    ;

statement
    : createStmt
    | generateStmt
    | selectStmt
    | usingStmt
    | outputStmt
    | loopStmt
    | includeStmt
    | exercisesStmt
    ;

exercisesStmt
    : 'Exercises' '=' '{' exerciseEntry+ '}'
    ;

exerciseEntry
    : IDENTIFIER '{' exerciseParams '}'
    ;

exerciseParams
    : ('Weight' '=' NUMBER)?
      (',' 'Sets' '=' NUMBER)?
      (',' 'Reps' '=' NUMBER)?
    ;

createStmt
    : 'create' identifier identifier '{' attributeList '}'
    ;

attributeList
    : attribute*
    ;

attribute
    : identifier ('(' value ')')
    | identifier '{' attributeList '}'
    | identifier '(' expression ')'
    ;

generateStmt
    : 'generate' identifier '{' paramList '}'
    | 'generate' identifier ('(' paramList ')')?
    | 'generate' reference parameterList
    ;

parameterList
    : identifier+
    ;

paramList
    : param (',' param)*
    ;

param
    : identifier ('(' value (',' value)* ')')?
    | identifier
    ;

value
    : literal
    | reference
    | identifier
    ;

selectStmt
    : 'select' identifier 'where' condition
    ;

condition
    : reference operator value
    | identifier operator value
    | reference '!=' 'done'
    ;

operator
    : '='
    | '>'
    | '<'
    ;

loopStmt
    : whileStmt
    | forStmt
    | foreachStmt
    ;

whileStmt
    : 'while' '(' condition ')' block
    ;

forStmt
    : 'for' '(' identifier ')' block
    | 'for' identifier 'in' iterable block
    ;

foreachStmt
    : 'foreach' reference '{' statement* '}'
    ;

includeStmt
    : 'include' identifier 'into' identifier
    ;

iterable
    : identifier
    | array
    | reference
    ;

outputStmt
    : 'output' expression ('as' identifier 'table')?
    | 'output' expression ('in' 'table' '(' identifier ')')?
    | 'output' reference
    ;

usingStmt
    : 'using' reference
    | 'using' identifier '.' identifier '=' literal
    ;

block
    : '{' statement* '}'
    ;

expression
    : mathExpr
    | reference
    | literal
    ;

mathExpr
    : NUMBER operator NUMBER
    | NUMBER '*' reference
    | reference '*' NUMBER
    ;

reference
    : identifier ('.' identifier)*
    ;

array
    : '{' (value (',' value)*)? '}'
    | '(' timeRange (',' timeRange)* ')'
    ;

timeRange
    : TIME_RANGE
    | TIME 'to' TIME
    ;
object
    : '(' value ')'
    | '{' attributeList '}'
    ;

identifier
    : IDENTIFIER
    | KEYWORD
    ;

literal
    : STRING
    | NUMBER
    | TIME
    | BOOLEAN
    ;

// Lexer Rules
KEYWORD
    : 'BMI'
    | 'Calories'
    | 'Goal'
    | 'Time'
    | 'Busy'
    | 'Weights'
    | 'Diet'
    | 'Alergic'
    | 'Standard'
    | 'Maintainance'
    | 'Breakfast'
    | 'Lunch'
    | 'Snack'
    | 'Dinner'
    | 'Proteins'
    | 'Carbs'
    | 'Fats'
    | 'avg'
    | 'avg_not_specified'
    | 'w_gear_not_specified'
    | 'fit'
    | 'table'
    | 'description'
    | 'all'
    ;

TIME_RANGE : TIME '-' TIME;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

STRING
    : '"' (~["\r\n\\] | '\\' .)* '"'
    | '\'' (~['\r\n\\] | '\\' .)* '\''
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9]+)?
    ;

TIME
    : [0-9]+ ':' [0-9][0-9] ('AM' | 'PM')?
    | [0-9]+ 'AM'
    | [0-9]+ 'PM'
    ;

BOOLEAN
    : 'true'
    | 'false'
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;