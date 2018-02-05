# Odstranění duplicitních prvků z posloupnosti a sdělení jejich počtu

Program je neinteraktivní, protože jde jen o ukázku algoritmu. Nikoliv o využití v praxi. Délka posloupnosti se dá měnit přímo v kódu, změnou exponentu k. Interval pro generování čísel je možné rovněž upravit jednoduše v kódu.

## Popis programu

Po spuštění programu dojde k náhodnému vygenerování posloupnosti z nastaveného intervalu čísel. Program seřadí posloupnost vzestupně a najde duplicitní prvky v posloupnosti. Přepíše posloupnost bez duplicit do nového pole a seřadí ji zpátky do původního stavu bez duplicit. 
Vypíše počet odstraněných duplicitních prvků. 

## Funkcionalita

Posloupnost je v programu uložena v poli a je generována pomocí funkce numbers.nextInt(), která je v samostatné metodě. V této metodě zároveň dojde k naplnění identifikačního pole, které reprezentuje pozice prvků v posloupnosti.  Z mainu dojde k volání metody selectsort, která setřídí posloupnost vzestupně a zároveň identicky setřídí pomocné pole. V mainu se vytvoří nová pole, která jsou použita v následující metodě hledaniduplicit. Metoda na základě vzestupného seřazení hledá duplicitní prvky. Následně přepíše posloupnost bez duplicitních prvků do nového pole, identicky se přepíše i pomocné pole. Metoda vrací počet odstraněných duplicitních prvků. V mainu dojde k tvorbě nových polí o velikosti posloupnosti bez duplicit a bez nulových hodnot na konci. Do těchto polí se přepíše posloupnost bez nulových hodnot na konci a hodnoty pomocného pole bez nulových hodnot na konci. Program zavolá znovu metodu selectsort, ale s vyměněnými poli. Dojde k seřazení podle pomocného pole a tím k identickému seřazení posloupnosti. Tím je posloupnost ve stejném stavu jako na 
začátku, akorát bez duplicit. Program vypíše počet odstraněných duplicitních prvků.

## Algoritmus

Jako jádro kódu jsem zvolil princip selectsortu, který jsem trochu upravil, aby to vyhovovalo i zpětnému třídění pomocí identifikačního pole. Selectsort funguje na principu vyhledání minima, které následně vymění za první prvek a začne hledat znovu od druhého prvku, dokud není řada setříděna. Na základě setříděnosti jsem duplicity vyhledával hrubou sílou. Algoritmus zvládá posloupnosti o velikosti 105 do cca 5 sekund. To není úplně ideální, jistě by bylo lepší zvládat 108. Možné vylepšení bych viděl ve změně třídícího algoritmu, použít například Quicksort. Bohužel si nejsem jistý, jestli by zde fungovalo zpětné třídění. V celém kódu jsem používal datový typ integer pro lepší přehlednost.

## Problematická místa

Největší problém byl zjistit, proč se posloupnost zpátky netřídí pokaždé správně. Problém spočíval v duplicitních prvcích a pomocném poli. Po setřídění posloupnosti nemuselo být pomocné pole v místech duplicitních prvků seřazeno vzestupně. A po odstranění duplicit se mohlo stát, že v posloupnosti zůstala dvojka s ID 9 místo dvojky s ID 1.  Po nalezení problému stačilo upravit selectsort.   

Dominik Mazur
