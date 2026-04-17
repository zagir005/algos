package algocodeio._02_hashtable._02_hash_table_key_selection

/** Задача с algocode.io, в lc такой нету

    Дан набор пар городов tickets, где tickets[i] = [город отправления, город прибытия] в которых побывал турист.
    Нужно восстановить маршрут следования туриста. Известно, что все города относятся к одному путешествию,
    и что каждый следующий перелёт турист начинал из того города, в котором закончил предыдущий
    и никакой город не был посещён туристом дважды.

    Пример 1:
    Ввод: tickets = [["Vladivostok","Moscow"]]
    Вывод: ["Vladivostok","Moscow"]

    Пример 2:
    Ввод: tickets = [["Moscow","Yerevan"],["Vladivostok","Moscow"],["Yerevan","NY"]]
    Вывод: ["Vladivostok","Moscow","Yerevan","NY"]

    по идее можно как-то использовать тот факт, что начальный город только один раз встретится
    на tickets[i[0]] и конечный один раз на tickets[i[1]]

    крч надо найти начальный город и из него выстроить цепочку.
    если закинуть в set только точки прибытия, то получим все города кроме начального.
    потом нужно закинуть все тикеты в мапу, ключом будет точка отправления и
    точка прибытия будет значением.

    O(n)
    O(n)
    >2hrs
*/

private fun route(tickets: List<List<String>>): List<String> {
    val ticketsSet = mutableSetOf<String>()
    val ticketsMap = mutableMapOf<String, String>()
    // в set закидываем только точки прибытия, исключая тем самым первую точку отбытия
    //конвертим тикеты в мапу
    //ключ - точка отбытия, значение - точка прибытия
    for (ticket in tickets) {
        ticketsSet.add(ticket[1])
        ticketsMap[ticket[0]] = ticket[1]
    }

    //находим изначальную точку отбытия
    var start = ""
    for ((from, _) in ticketsMap) {
        if (from !in ticketsSet){
            start = from
            break
        }
    }

    val ansArr = mutableListOf<String>()
    var curr = start
    while (curr in ticketsMap) {
        ansArr.add(curr)
        curr = ticketsMap[curr]!!

    }

    ansArr.add(curr)
    return ansArr
}


