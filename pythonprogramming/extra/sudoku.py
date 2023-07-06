from PuLp import plp
def solve_sudoku(input_sudoku, diagonal = False ):
    # Create the linear programming problem
    prob = plp.LpProblem("Sudoku_Solver")

    rows = range(0,4)
    cols = range(0,4)
    grids = range(0,4)
    values = range(1,5)

    # Decision Variable/Target variable
    grid_vars = plp.LpVariable.dicts("grid_value", (rows,cols,values), cat='Binary') 

    # Set the objective function
    # Sudoku works only on the constraints - feasibility problem 
    # There is no objective function that we are trying maximize or minimize.
    # Set a dummy objective
    objective = plp.lpSum(0)
    prob.setObjective(objective)

    # Create the default constraints to solve sudoku
    add_default_sudoku_constraints(prob, grid_vars, rows, cols, grids, values)

    # Add the diagonal constraints if flag is set
    if (diagonal):
        add_diagonal_sudoku_constraints(prob, grid_vars, rows, cols, values)
        
    # Fill the prefilled values from input sudoku as constraints
    add_prefilled_constraints(prob, input_sudoku, grid_vars, rows, cols, values)


    # Solve the problem
    prob.solve()

    # Print the status of the solution
    solution_status = plp.LpStatus[prob.status]
    print(f'Solution Status = {plp.LpStatus[prob.status]}')

    # Extract the solution if an optimal solution has been identified
    if solution_status == 'Optimal':
        solution = extract_solution(grid_vars, rows, cols, values)
        print_solution(solution, rows,cols)
    
l=[]
for i in range (0,5):
    p=list(map(str,input().split()))
    for j in range (0,5):
        if p[i]=='#':
            p[i]=0
        else:
            p[i]=int(p[i])

    l.append(p)

solve_sudoku(input_sudoku=l,diagonal=False)