# Trie https://m.blog.naver.com/cjsencks/221740232900

class Node(object):
    def __init__(self, key, data=None):
        self.key = key  # 값으로 입력될 문자
        self.data = data    # 문자열의 종료를 알리는 flag (전체 문자열을 저장)
        self.children = {}  # 자식 노드를 저장


class Trie:
    # head를 빈 노드로 설정
    def __init__(self):
        self.head = Node(None)

    # 트리를 생성하기 위한 함수
    def insert(self, string):
        cur_node = self.head

        for ch in string:
            if ch not in cur_node.children:
                cur_node.children[ch] = Node(ch)
            cur_node = cur_node.children[ch]

        cur_node.data = string

    # 문자열이 존재하는지에 대한 여부를 리턴
    def search(self, string):
        cur_node = self.head

        for ch in string:
            if ch in cur_node.children:
                cur_node = cur_node.children[ch]
            else:
                return False

        if cur_node.data:
            return True

        return False

    # prefix 단어로 시작하는 단어를 찾고 배열로 리턴
    def start_with(self, prefix):
        cur_node = self.head
        words = []

        # prefix 까지 tree를 순회
        for p in prefix:
            if p in cur_node.children:
                cur_node = cur_node.children[p]
            else:
                return None

        cur_node = [cur_node]
        nxt_node = []

        while True:
            # 그 다음 부터 data가 존재하는 것들만 배열에 저장
            for node in cur_node:
                if node.data:
                    words.append(node.data)
                nxt_node.extend(list(node.children.values()))

            if len(nxt_node) != 0:
                cur_node = nxt_node
                nxt_node = []
            else:
                break

        return words


trie = Trie()
words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]

for word in words:
    trie.insert(word)

print(trie.start_with("f"))
