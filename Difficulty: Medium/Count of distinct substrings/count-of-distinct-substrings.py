class Solution:
    def countSubs(self, s):
        # Suffix Automaton implementation
        
        # Each state: {length, link, transitions}
        st = [{"len": 0, "link": -1, "next": {}}]
        last = 0  # points to the state representing whole string so far
        
        def sa_extend(c):
            nonlocal last
            cur = len(st)
            st.append({"len": st[last]["len"] + 1, "link": 0, "next": {}})
            
            p = last
            # Update transitions
            while p != -1 and c not in st[p]["next"]:
                st[p]["next"][c] = cur
                p = st[p]["link"]
            
            if p == -1:
                st[cur]["link"] = 0
            else:
                q = st[p]["next"][c]
                if st[p]["len"] + 1 == st[q]["len"]:
                    st[cur]["link"] = q
                else:
                    clone = len(st)
                    st.append({
                        "len": st[p]["len"] + 1,
                        "next": st[q]["next"].copy(),
                        "link": st[q]["link"]
                    })
                    while p != -1 and st[p]["next"].get(c) == q:
                        st[p]["next"][c] = clone
                        p = st[p]["link"]
                    st[q]["link"] = st[cur]["link"] = clone
            
            last = cur
        
        # Build SAM
        for c in s:
            sa_extend(c)
        
        # Count distinct substrings
        ans = 0
        for i in range(1, len(st)):
            ans += st[i]["len"] - st[st[i]["link"]]["len"]
        
        return ans
