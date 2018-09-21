import time,threading,multiprocessing
# def loop():
#     print('threading %s is running....' % threading.current_thread().name)
#     n=0
#     while n<5:
#     	n = n + 1
#     	print('thread %s >>> %s' % (threading.current_thread().name, n))
#     	time.sleep(1)
#         # time.sleep(1)
#     print('thread %s ended.' % threading.current_thread().name)
# print('thread %s is running...' % threading.current_thread().name)
# t = threading.Thread(target = loop,name = 'LoopThread')
# t.start()
# t.join()
# print('threading  %s end' % threading.current_thread().name)


# 假定这是你的银行存款:
balance = 0
lock = threading.Lock()

def change_it(n):
    # 先存后取，结果应该为0:
    global balance
    balance = balance + n
    balance = balance - n

def run_thread(n):
    for i in range(100000):
    	# 先要获取锁:
    	# 当多个线程同时执行lock.acquire()时，只有一个线程能成功地获取锁，然后继续执行代码，其他线程就继续等待直到获得锁为止。
        lock.acquire()
        try:
            change_it(n)
        finally:
        	# 获得锁的线程用完后一定要释放锁，否则那些苦苦等待锁的线程将永远等待下去，成为死线程。所以我们用try...finally来确保锁一定会被释放。
    	    lock.release()


t1 = threading.Thread(target=run_thread, args=(5,))
t2 = threading.Thread(target=run_thread, args=(8,))
t1.start()
t2.start()
t1.join()
t2.join()
print(balance)

# def loop():
# 	x = 0
# 	while True:
# 		x=x^1

# for i in range(multiprocessing.cpu_count()):
# 	t = threading.Thread(target=loop)
# 	t.start()

# Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。

