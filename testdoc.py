from typing import ItemsView


def get_user_values(begin):
    user_values = []
    for i in range(begin):
        num = int(input())
        user_values.append(num)
        i += 1
    upper_threshold = user_values[-1]
    del user_values[-1]
    return user_values, upper_threshold
    
def output_ints_less_than_or_equal_to_threshold(user_values, upper_threshold):
    answers = []
    for value in user_values <= 100:
        answers.append(value)
    return answers 
    

if __name__ == '__main__':
    begin = int(input())
    get_user_values(begin)
    user_values, upper_threshold = get_user_values(begin)
    output_ints_less_than_or_equal_to_threshold(user_values, upper_threshold)
    


    