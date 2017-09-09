# angluar NgModule
### use the decorator to the class @NgModule
> declarations 
>>    View Class :   
        1. components   
        2. directives   
        3. pipes
> exports
>>    declarations's subSet   
        1. the component template visited and used by other components
> imports
>>    other modules exports classes   
        1. need the other components' exports component template
> providers
>>    creator of services   
        1. add to global services   
        2. can be accessable in any parts of app
> bootstrap 
>>    the main application view   
        1. the root component   
        2. hosts all other app views
        3. only root component should set to

### there has anther different way to export Module
    1. use the export of es's module
    2. two module is different,but they are complementary 
