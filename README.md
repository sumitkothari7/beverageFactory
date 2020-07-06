# beverageFactory

I have created a java command line project. Import in intellij or eclipse and execute main method. It will accept order from command line.

I have used HashMap for caching the menu item and use Menu factory to find which menu item is ordered. 

I started thinking of using factory design pattern for Menu items but as menu items will keeps on growing and it will be easier if we maintain it in database and query it from there. Even the Menu factory will need to modify to get menu item from database.

Created 3 services which are as follows.
1. OrderBuilderService:  It will take string as an input and create Order object.
2. ValidateOrderService: It will validate if the correct order is place or not.
3. PriceCalculatorService: It will calculate the price of the order and return it to calling method.

OrderProcessor is entry point and written test cases for same.

Added lib folder which contians junit jars.
